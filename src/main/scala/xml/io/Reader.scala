package xml.io

import xml.Element

import scala.io.Source
import scala.util.{Failure, Success, Try}

object Reader {
  def load(file: String): Either[Element, Error] = {
    def readFromFile(): Try[List[String]] =
      Try(Source.fromFile(file).getLines().toList)

    readFromFile() match {
      case Success(lines) => Left(Element("asd"))
      case Failure(err)     => Right(BadFile(err.toString))

    }
  }
}
