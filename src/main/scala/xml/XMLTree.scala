package xml


case class Element(name: String,
                   attributes: Set[Attribute],
                   elements: Set[Element],
                   value: Option[Value]) extends XML {
  override def toXml: String = ???

  def add(attr: Attribute): Element =
    Element(name, attributes + attr, elements, value)

  // used DummyImplicit because of type erasure raising an error => Set[Element] fundamentally gets reduced to Set[Obj]
  def add(attrs: Set[Attribute])(implicit d: DummyImplicit): Element =
    Element(name, attributes ++ attrs, elements, value)

  def add(child: Element): Element =
    Element(name, attributes, elements + child, value)

  def add(children: Set[Element]): Element =
    Element(name, attributes, elements ++ children, value)

  def remove(attr: Attribute): Element =
    Element(name, attributes - attr, elements, value)

  def remove(attrs: Set[Attribute]): Element =
    Element(name, attributes -- attrs, elements, value)

  def remove(child: Element): Element =
    Element(name, attributes, elements - child, value)

  // used DummyImplicit because of type erasure raising an error => Set[Element] fundamentally gets reduced to Set[Obj]
  def remove(children: Set[Element])(implicit d: DummyImplicit): Element =
    Element(name, attributes, elements -- children, value)

  def edit(old: Element, updated: Element): Element =
    Element(name, attributes, elements(old) = updated, value)

  def edit(old: Attribute, updated: Attribute): Element =
    Element(name, attributes(old) = updated, elements, value)

  def edit(newValue: Option[Value]): Element =
    Element(name, attributes, elements, newValue)
}


case class Attribute(name: String, value: Attribute) extends XML {
  override def toXml: String = s" $name = \"$value\" "
}


case class Value(value: String) extends XML {
  override def toXml: String = s"$value"
}

