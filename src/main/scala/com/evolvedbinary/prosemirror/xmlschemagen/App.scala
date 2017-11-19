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

import java.net.URL
import java.nio.file.{Files, Path, Paths}
import javax.xml.namespace.QName

import com.evolvedbinary.prosemirror.xmlschemagen.ProseMirror.{Namespaces, ProseMirrorSchemaResult}

import scala.util.{Failure, Success, Try}

object CmdLine {

  val EXIT_CODE_INVALID_ARGS = 1
  val EXIT_CODE_SCHEMA_ERROR = 2

  case class ParsedArgs(schemaFile: Option[Path] = Option.empty, namespaces: Namespaces = Map.empty, rootElement: Option[String] = Option.empty)

  def isValidPrefix(prefix: String) = !prefix.contains(":")

  def isValidUrl(url: String) = {
    Try(new URL(url)) match {
      case Success(_) => true
      case Failure(_) => false
    }
  }

  implicit val pathRead: scopt.Read[Path] = scopt.Read.reads(Paths.get(_))

  val parser = new scopt.OptionParser[ParsedArgs]("xmlschemagen") {
    head("xmlschemagen", "0.1")

    opt[Namespaces]("namespace").valueName("prefix1=url1,prefix2=url2,...").action((x, c) =>
      c.copy(namespaces = c.namespaces ++ x)
    ).validate(namespaces =>
      namespaces.collectFirst {
        case (prefix, url) if(!isValidPrefix(prefix) || !isValidUrl(url)) => failure(s"Invalid namespace mapping: ${prefix}=${url}")
      }.getOrElse(success)
    ).text("A namespace mapping from prefix to URL.")

    help("help").text("prints this usage text")

    arg[Path]("<schema>").required().action((x, c) =>
      c.copy(schemaFile = Some(x))
    ).validate(path =>
      if(Files.exists(path)) {
        success
      } else {
        failure("Schema file must exist.")
      }
    ).text("The path to the XML Schema file to parse.")

    arg[String]("<root element>").required().action((x, c) =>
      c.copy(rootElement = Some(x))
    ).text("The name of the element in the XML Schema to treat as the root element. Can be expressed as prefix:local name or just local name.")
  }

  def main(args: Array[String]) {
    parser.parse(args, ParsedArgs()) match {
      case Some(parsedArgs) =>
        val schemaGen = new SchemaGen()

        val pmSchema: ProseMirrorSchemaResult = schemaGen
          .parse(parsedArgs.schemaFile.get)
          .flatMap { parsedSchema =>
            toQName(parsedArgs.rootElement.get, parsedArgs.namespaces).flatMap { rootElementName =>
              schemaGen.toProseMirrorSchema(parsedSchema, rootElementName)
            }
          }

        pmSchema match {
          case Right(pms) =>
            val prefixes = parsedArgs.namespaces.map(_.swap)
            println(pms.asJson(prefixes))

          case Left(t) =>
            t.printStackTrace()
            System.exit(EXIT_CODE_SCHEMA_ERROR)
        }

      case None =>
        System.exit(EXIT_CODE_INVALID_ARGS)
    }
  }

  private def toQName(rootElement: String, namespaces: Namespaces): Either[Throwable, QName] = {
    val parts = rootElement.split(':')
    if(parts.length == 1) {
      Try(new QName(parts(0))).toEither

    } else if(parts.length == 2) {
      val nsPrefix = parts(0)
      namespaces.get(nsPrefix) match {
        case Some(nsUrl) =>
          Try(new QName(nsUrl, parts(1), nsPrefix)).toEither

        case None =>
          Left(new IllegalArgumentException(s"No namespace defined for prefix: $nsPrefix"))
      }

    } else {
      Left(new IllegalArgumentException(s"Invalid root element name: $rootElement"))
    }
  }

}
