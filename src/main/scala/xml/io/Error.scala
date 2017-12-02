package xml.io

sealed trait Error

case object InvalidXMLFile extends Error

case object BadFile extends Error



