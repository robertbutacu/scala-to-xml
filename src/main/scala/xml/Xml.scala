package xml

abstract class XML

abstract class XMLNodeDetails extends XML{
  def toXml: String
}

abstract class XMLNode extends XML{
  def toXml(depth: Int): String
}
