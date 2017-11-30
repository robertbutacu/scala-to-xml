package xml

trait XML

trait XMLLeaf extends XML{
  def toXml: String
}

trait XMLRoot extends XML{
  def toXml(depth: Int): String
}