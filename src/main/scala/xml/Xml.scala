package xml

trait XML

trait XMLNodeDetails extends XML{
  def toXml: String
}

trait XMLNode extends XML{
  def toXml(depth: Int): String
}