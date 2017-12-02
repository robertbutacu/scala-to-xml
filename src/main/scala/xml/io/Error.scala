package xml.io

sealed trait Error

case class InvalidXMLFile(lineErr: Int = 0) extends Error

case class BadFile(err: String = "") extends Error



