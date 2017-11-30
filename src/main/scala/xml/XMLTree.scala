package xml


case class Element(name: String,
                   attributes: List[Attribute],
                   childElements: List[Element],
                   value: Option[String]) extends XML {
  override def toXml: String = ???

  def addAttribute(attr: Attribute): Element = ???

  def removeAttribute(attr: Attribute): Element = ???

  def addChild(child: Element): Element = ???

  def removeChild(child: Element): Element = ???

  def editChild(old: Element, updated: Element): Element = ???

  def editValue(newValue: Value): Element = ???
}


case class Attribute(name: String, value: Attribute) extends XML {
  override def toXml: String = s" $name = \"$value\" "
}


case class Value(value: String) extends XML {
  override def toXml: String = s"$value"
}

