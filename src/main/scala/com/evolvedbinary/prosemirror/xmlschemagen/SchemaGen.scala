/*
 * Copyright (C) 2017  Adam Retter
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.evolvedbinary.prosemirror.xmlschemagen

import java.io.InputStream
import java.nio.file.{Files, Path}
import java.nio.charset.StandardCharsets.UTF_8
import javax.xml.namespace.QName

import cats.effect.IO
import com.evolvedbinary.prosemirror.xmlschemagen.ProseMirror._
import org.apache.xerces.impl.xs.{SchemaGrammar, XMLSchemaLoader}
import org.apache.xerces.xni.parser.XMLInputSource
import org.apache.xerces.xs._

class SchemaGen {

  def parse(schema: Path) : Either[Throwable, ParsedSchema] = {
    val io = bracket[InputStream, SchemaGrammar](IO.apply(Files.newInputStream(schema)), is => IO.apply(is.close)) { is =>
      IO.apply(new XMLInputSource(null, schema.toUri.toString, null, is, UTF_8.displayName))
        .map(new XMLSchemaLoader().loadGrammar)
        .map(_.asInstanceOf[SchemaGrammar])
    }

    io.attempt
      .unsafeRunSync()
      .map(ParsedSchema)
  }

  type ProseMirrorSchemaResult = Either[Throwable, Seq[PMSchemaNode]]

  def toProseMirrorSchema(parsedSchema: ParsedSchema, rootElementName: QName) : ProseMirrorSchemaResult = {
    val model = parsedSchema
      .grammar
      .toXSModel
    Option(model.getElementDeclaration(rootElementName.getLocalPart, rootElementName.getNamespaceURI)
    ) match {
      case Some(rootElement) =>
        processRootElementDeclaration(model, rootElement)

      case None =>
        Left(new IllegalArgumentException(s"Could not find root element in Schema named: $rootElementName"))
    }
  }

  private def processRootElementDeclaration(model: XSModel, rootElementDecl: XSElementDeclaration) : ProseMirrorSchemaResult = {

    def processAll(elementDecl: XSElementDeclaration, processed: Set[String] = Set.empty) : Either[Throwable, (Seq[PMSchemaNode], Set[String])] = {
      val nowProcessed = processed + elementDecl.getName  //TODO(AR) figure out namespaces!

//      println(s"processAll=${elementDecl.getName}")

      elementToProseMirrorSchemaNode(model, elementDecl) match {
        case Right(schemaNode) =>
          val contentRefNames = schemaNode.getContentNodeRefNames()

//          println(s"    children=${contentRefNames}")


          val initAccum : Either[Throwable, (Seq[PMSchemaNode], Set[String])] = Right((Seq(schemaNode), nowProcessed))
          contentRefNames
            .filterNot(nowProcessed.contains)
            .foldLeft(initAccum) { (accum, x) =>
              accum match {

                case right @ Right((accumNodes, accumProcessed)) =>
                  Option(model.getElementDeclaration(x, "")) match {  //TODO(AR) figure out namespaces!

                    case Some(ed) =>
                      if(!accumProcessed.contains(ed.getName)) {    //TODO(AR) figure out namespaces!
                        processAll(ed, accumProcessed)
                          .map {
                            case (resNodes, resProcessed) =>
                              (accumNodes ++ resNodes, accumProcessed ++ resProcessed)
                          }
                      } else {
                        // nothing to do, already processed
                        right
                      }

                    case None =>
                      Left(new IllegalStateException(s"Count not find element declaration in model for: $x"))
                  }

                case left @ Left(_) => left
              }
            }

          // take 1 contentRefName
          // get the element decl

        case Left(t) => Left(t)
      }
    }

    val results = processAll(rootElementDecl)
    results.map(_._1)
  }

  private def elementToProseMirrorSchemaNode(model: XSModel, elementDecl: XSElementDeclaration): Either[Throwable, PMSchemaNode] = {
    val children = getChildren(model, elementDecl)
    children.map(c => PMSchemaNode(elementDecl.getName, c._1, c._2))
  }


  private type NodeChildren = Either[Throwable, (Seq[PMSchemaNodeAttribute], Seq[PMSchemaNodeContentItem])]

  private def getChildren(model: XSModel, elementDecl: XSElementDeclaration) : NodeChildren = {
    val typeDef = elementDecl.getTypeDefinition
    typeDef.getTypeCategory match {
      case XSTypeDefinition.SIMPLE_TYPE =>
        processType(typeDef.asInstanceOf[XSSimpleTypeDefinition])

      case XSTypeDefinition.COMPLEX_TYPE =>
        val complexType = typeDef.asInstanceOf[XSComplexTypeDefinition]
        if(Option(complexType.getName) != Some("anyType")) {
          processType(model, complexType)
        } else {
          Right((Seq.empty, Seq.empty))
        }
    }
  }

  private def processType(simpleTypeDef: XSSimpleTypeDefinition) : NodeChildren = {
    Right((Seq.empty, Seq.empty))
  }

  private def processType(model: XSModel, complexTypeDef: XSComplexTypeDefinition): NodeChildren = {
    val attributes = getAttributes(model, complexTypeDef)
    attributes.flatMap { attrs =>
      Option(complexTypeDef.getParticle)
        .map(processParticle(model, _))
        .getOrElse(Right(Seq.empty))
        .map(contentItems => (attrs, contentItems))
    }
  }

  private def getAttributes(model: XSModel, complexTypeDef: XSComplexTypeDefinition) : Either[Throwable, Seq[PMSchemaNodeAttribute]] = {
    val objectList = complexTypeDef.getAttributeUses
    val attrs = for(i <- (0 until objectList.getLength))
      yield objectList.item(i).asInstanceOf[XSAttributeUse]

    Right(attrs.map { attr =>
      PMSchemaNodeAttribute(attr.getAttrDeclaration.getName, attr.getRequired, Option(attr.getValueConstraintValue).map(_.getNormalizedValue))
    })
  }

  private type NodeContentResult = Either[Throwable, Seq[PMSchemaNodeContentItem]]

  private def processParticle(model: XSModel, particle: XSParticle) : NodeContentResult = {
    processTerm(model, particle.getTerm, asCardinality(particle))
  }

  private def processTerm(model: XSModel, term: XSTerm, cardinality: Cardinalities.Cardinality) : NodeContentResult = {
    term.getType match {

//      case XSConstants.ATTRIBUTE_DECLARATION =>
//        //TODO(AR) what to do with attributes
//        Right(Seq.empty)
//
      case XSConstants.ELEMENT_DECLARATION =>
        processElementDeclaration(model, term.asInstanceOf[XSElementDeclaration], cardinality)

      case XSConstants.MODEL_GROUP =>
        processModelGroup(model, term.asInstanceOf[XSModelGroup], cardinality)

      case _ =>
        Left(new UnsupportedOperationException(s"Not yet implemented process term for type: ${term.getType}"))
    }
  }

  private def processElementDeclaration(model: XSModel, elementDecl: XSElementDeclaration, cardinality: Cardinalities.Cardinality): NodeContentResult = {
    if(elementDecl.getAbstract) {
      Option(model.getSubstitutionGroup(elementDecl)) match {
        case Some(objectList) =>
          processObjectList(model, objectList).map(res => Seq(PMSchemaNodeRefGroup(res, Compositors.EITHER, Cardinalities.ONE)))

        case None =>
          Left(new IllegalStateException(s"Cannot find substitutionGroup for abstract element: ${elementDecl.getName}"))
      }
    } else {
      Right(Seq(PMSchemaNodeRef(elementDecl.getName, cardinality))) //TODO(AR) need to fix the cardinality
    }
  }

  private def processModelGroup(model: XSModel, modelGroup: XSModelGroup, cardinality: Cardinalities.Cardinality) : NodeContentResult = {
    processObjectList(model, modelGroup.getParticles)
        .map(items => Seq(PMSchemaNodeRefGroup(items, asCompositor(modelGroup), cardinality)))
  }

  private def processObjectList(model: XSModel, objectList: XSObjectList) : NodeContentResult = {
    val objects = for(i <- (0 until objectList.getLength))
      yield objectList.item(i)

    // only evaluate until we get the first error, can use fold to do that
    val emptyAccum : NodeContentResult = Right(Seq.empty[PMSchemaNodeRef])
    objects.foldLeft(emptyAccum)((accum, x) =>
      accum match {
        case Right(refs) =>
          processObject(model, x).map(xs => refs ++ xs)
        case left @ Left(_) => left
      }
    )
  }

  private def processObject(model: XSModel, obj: XSObject) : NodeContentResult = {
    obj.getType match {
      case XSConstants.ELEMENT_DECLARATION =>
        processElementDeclaration(model, obj.asInstanceOf[XSElementDeclaration], Cardinalities.ONE) //TODO(AR) fix cardinality

      case XSConstants.PARTICLE =>
        processParticle(model, obj.asInstanceOf[XSParticle])

      case _ =>
        Left(new UnsupportedOperationException(s"Not yet implemented object processing of object type: ${obj.getType}"))
    }
  }

  private def bracket[A, B](alloc: IO[A], close: A => IO[Unit])(use: A => IO[B]): IO[B] =
    alloc.flatMap { a =>
      use(a).attempt.map(b => {close(a).attempt; b}).flatMap {
        case Right(b) =>
          IO.apply(b)
        case Left(t) =>
          IO.raiseError(t)
      }
    }

  private def asCardinality(obj: {def getMinOccurs(): Int; def getMaxOccurs(): Int}) : Cardinalities.Cardinality = {
    obj.getMinOccurs match {
      case 0 =>
        obj.getMaxOccurs match {
          case 1 =>
            Cardinalities.ZERO_OR_ONE

          case -1 =>  //unbounded
            Cardinalities.ZERO_OR_MORE
        }

      case 1 =>
        obj.getMaxOccurs match {
          case 1 =>
            Cardinalities.ONE

          case -1 =>  //unbounded
            Cardinalities.ONE_OR_MORE
        }
    }
  }

  private def asCompositor(obj: { def getCompositor(): Short}) : Compositors.Compositor = {
    obj.getCompositor() match {
      case XSModelGroup.COMPOSITOR_SEQUENCE => Compositors.SEQUENCE
      case XSModelGroup.COMPOSITOR_CHOICE => Compositors.EITHER
      case XSModelGroup.COMPOSITOR_ALL => throw new UnsupportedOperationException("not yet implemented all compositor")
    }
  }


}

/**
  * Just an API abstraction around the Xerces result
  */
case class ParsedSchema(grammar: SchemaGrammar)
