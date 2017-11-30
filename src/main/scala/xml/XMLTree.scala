package xml


case class Element(name: String,
                   attributes: List[Attribute],
                   childElements: List[Element],
                   value: Option[String]) extends XML {
  override def toXml: String = ???

  def add(attr: Attribute): Element = ???

  def add(attrs: List[Attribute]): Element = ???

  def add(child: Element): Element = ???

  def remove(attr: Attribute): Element = ???

  def remove(child: Element): Element = ???

  def edit(old: Element, updated: Element): Element = ???

  def edit(newValue: Value): Element = ???
}


case class Attribute(name: String, value: Attribute) extends XML {
  override def toXml: String = s" $name = \"$value\" "
}


case class Value(value: String) extends XML {
  override def toXml: String = s"$value"
}

