package xml.io

import xml.Element

import scala.annotation.tailrec
import scala.collection.immutable.Stack
import scala.io.Source
import scala.util.{Failure, Success, Try}

object Reader {
  def load(file: String): Either[Element, Error] = {
    def readFromFile(): Try[List[String]] =
      Try(Source.fromFile(file).getLines().toList)

    readFromFile() match {
      case Success(lines) => Left(Element("asd"))
      case Failure(err)   => Right(BadFile(err.toString))
    }
  }

  private def parse(lines: List[String]): Either[Element, Error] = {
    def go(lines: List[(String, Int)],
           stack: List[String],//see as stack
           isElement: Boolean = false,
           isValue: Boolean = false,
           carry: String = ""): Either[Element, Error] = {
      Right(InvalidXMLFile())
    }

    go(lines.zipWithIndex, List.empty)
  }
}
