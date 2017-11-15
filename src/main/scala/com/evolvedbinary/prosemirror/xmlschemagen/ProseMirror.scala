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

object ProseMirror {

  type NodeName = String

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
    def asJson: String
  }

  sealed trait PMSchemaNodeContentItem extends JsonSerializable
  case class PMSchemaNodeRef(name: NodeName, cardinality: Cardinalities.Cardinality) extends PMSchemaNodeContentItem {
    override def asJson: String = {
      s"${name}${cardinality.symbol}"
    }
  }

  case class PMSchemaNodeRefGroup(group: Seq[PMSchemaNodeContentItem], compositor: Compositors.Compositor, cardinality: Cardinalities.Cardinality) extends PMSchemaNodeContentItem {
    override def asJson: String = {
      s"(${group.map(_.asJson).mkString(compositor.separator)})${cardinality.symbol}"
    }
  }

  case class PMSchemaNode(name: NodeName, content: Seq[PMSchemaNodeContentItem]) {
    private def asJson(content: Seq[PMSchemaNodeContentItem]): String = {
      content.map(_.asJson).mkString(" ")  //TODO(AR) mkString concats at the moment
    }

    def getContentNodeRefNames(): Seq[String] = {
      def getRefNames(contentItem: PMSchemaNodeContentItem): Seq[String] = {
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
        .foldLeft(Seq.empty[String]){ (accum, x) => accum ++ x}
    }

    def asJson: String = {
      s"""$name: {
         |    content: "${asJson(content)}"
         |}""".stripMargin
    }
  }
}
