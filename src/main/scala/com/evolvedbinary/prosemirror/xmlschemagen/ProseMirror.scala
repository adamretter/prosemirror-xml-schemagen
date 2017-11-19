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

import javax.xml.namespace.QName

object ProseMirror {

  type NodeName = QName
  type NsPrefix = String
  type NsURL = String
  type Namespaces = Map[NsPrefix, NsURL]
  type Prefixes = Map[NsURL, NsPrefix]

  type ProseMirrorSchemaResult = Either[Throwable, PMSchema]

  val EOL = sys.props("line.separator")

  def qnameToJsonName(prefixes: Prefixes, name: QName) : String = {
    Option(name.getNamespaceURI)
      .filter(_.nonEmpty)
      .flatMap(prefixes.get(_))
      .map(prefix => s"$prefix:")
      .getOrElse("") + name.getLocalPart
  }

  object Cardinalities {
    sealed abstract class Cardinality(val symbol: String)
    case object ZERO_OR_ONE extends Cardinality("?")
    case object ONE extends Cardinality("")
    case object ONE_OR_MORE extends Cardinality("+")
    case object ZERO_OR_MORE extends Cardinality("*")
  }

  object Compositors {
    sealed abstract class Compositor(val separator: String)
    case object EITHER extends Compositor(" | ")
    case object SEQUENCE extends Compositor(" ")
  }

  sealed trait JsonSerializable {
    def asJson(prefixes: Prefixes): String
  }

  case class PMSchemaNodeAttribute(name: String, required: Boolean, default: Option[String]) extends JsonSerializable {
    override def asJson(prefixes: Prefixes): String = {
      def defaultVal() : String = {
        if(required) {
          s""""${default.getOrElse("")}""""
        } else {
          default.map(d => s""""${d}"""").getOrElse("undefined")
        }
      }

      s"${name}: {default: ${defaultVal()}}"
    }
  }

  sealed trait PMSchemaNodeContentItem extends JsonSerializable
  case class PMSchemaNodeRef(name: NodeName, cardinality: Cardinalities.Cardinality) extends PMSchemaNodeContentItem {
    override def asJson(prefixes: Prefixes): String = {
      s"${qnameToJsonName(prefixes, name)}${cardinality.symbol}"
    }
  }

  case class PMSchemaNodeRefGroup(group: Seq[PMSchemaNodeContentItem], compositor: Compositors.Compositor, cardinality: Cardinalities.Cardinality) extends PMSchemaNodeContentItem {
    override def asJson(prefixes: Prefixes): String = {
      s"(${group.map(_.asJson(prefixes)).mkString(compositor.separator)})${cardinality.symbol}"
    }
  }

  case class PMSchemaNode(name: NodeName, attributes: Seq[PMSchemaNodeAttribute], content: Seq[PMSchemaNodeContentItem], inline: Boolean) {
    def getContentNodeRefNames(): Seq[NodeName] = {
      def getRefNames(contentItem: PMSchemaNodeContentItem): Seq[NodeName] = {
        contentItem match {
          case PMSchemaNodeRef(name, _) =>
            Seq(name)

          case PMSchemaNodeRefGroup(items, _, _) =>
            items.map{ item =>
              getRefNames(item)
            }.flatten
        }
      }

      content
        .map(getRefNames)
        .filterNot(_.isEmpty)
        .foldLeft(Seq.empty[NodeName]){ (accum, x) => accum ++ x}
    }

    private def contentAsJson(prefixes: Prefixes, content: Seq[PMSchemaNodeContentItem]): Option[String] = {
      Option(content.map(_.asJson(prefixes)).mkString(" ")).filterNot(_.isEmpty)  //TODO(AR) mkString concats at the moment
    }

    private def attrsAsJson(prefixes: Prefixes, attribute: Seq[PMSchemaNodeAttribute]) : Option[String] = {
      Option(attributes.map(_.asJson(prefixes)).mkString(", ")).filterNot(_.isEmpty)
    }

    private def inlineAsJson(inline: Boolean): Option[String] = {
      if(inline) {
        Some("        inline: true")
      } else {
        None
      }
    }

    def asJson(prefixes: Prefixes): String = {
      val contentStr = contentAsJson(prefixes, content).map(c => s"""        content: "${c}"""")
      val attrStr = attrsAsJson(prefixes, attributes).map(a => s"""        attrs: {${a}}""")

      s"""    "${qnameToJsonName(prefixes, name)}": {
         |${Seq(contentStr, attrStr, inlineAsJson(inline)).flatten.mkString(s",$EOL")}
         |    }""".stripMargin
    }
  }

  case class PMSchema(nodes: Seq[PMSchemaNode]) extends JsonSerializable {
    def asJson(prefixes: Prefixes): String = {
      s"""nodes: {
         |${nodes.map(_.asJson(prefixes)).mkString(s",$EOL$EOL")}
         |}""".stripMargin
    }
  }
}
