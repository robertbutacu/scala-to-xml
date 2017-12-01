package xml


case class Element(name: String,
                   attributes: Set[Attribute] = Set.empty,
                   elements: Set[Element] = Set.empty,
                   value: Option[Value] = None) extends XMLNode {
  /**
    *
    * @param depth - serves as indentation in number of tabs
    * @return - a string representing the Element serialized
    */
  override def toXml(depth: Int = 0): String = {
    def elementToXml(element: Element, depth: Int): String =
      "\t" * depth + element.toXml(depth)

    s"<$name${attributes.map(_.toXml).mkString(" ")}> ${if (elements.nonEmpty) "\n" else ""}" +
      s"${elements.map(elementToXml(_, depth + 1)).mkString("\n")}" +
      s"${
        value.map {
          if (elements.nonEmpty) "\t" * depth + _.toXml + "\n"
          else _.toXml
        }.mkString
      }" +
      s"${
        if (elements.nonEmpty) "\t" * depth
        else ""
      }</$name>\n"
  }

  /**
    *
    * @param attr - new attribute to be added
    * @return - a new element containing the element
    */
  def add(attr: Attribute): Element =
    Element(name, attributes + attr, elements, value)

  /**
    * used DummyImplicit because of type erasure raising an error
    *
    * => Set[Element] fundamentally gets reduced to Set[Obj], same as any Set()
    * @param attrs - new attributes to be added
    * @param d     - implicit dummy to avoid compilation error
    * @return - a new element with the new attributes added
    */
  def add(attrs: Set[Attribute])(implicit d: DummyImplicit): Element =
    Element(name, attributes ++ attrs, elements, value)

  /**
    *
    * @param child - adding a new node in the tree
    * @return - new element with the new node added
    */
  def add(child: Element): Element =
    Element(name, attributes, elements + child, value)

  /**
    *
    * @param children - new nodes to be added
    * @return - new element with the new nodes added
    */
  def add(children: Set[Element]): Element =
    Element(name, attributes, elements ++ children, value)

  /**
    *
    * @param attr - attribute to be removed
    * @return - element without the attribute
    */
  def remove(attr: Attribute): Element =
    Element(name, attributes - attr, elements, value)

  /**
    *
    * @param attrs - a set of attributes that are to be removed from the current element
    * @return - element where attributes are without attrs
    */
  def remove(attrs: Set[Attribute]): Element =
    Element(name, attributes -- attrs, elements, value)

  /**
    *
    * @param child - node to be removed
    * @return - node without child
    */
  def remove(child: Element): Element =
    Element(name, attributes, elements - child, value)

  /**
    * used DummyImplicit because of type erasure raising an error
    *
    * => Set[Element] fundamentally gets reduced to Set[Obj], same as any kind of Set[]
    * @param children - set of nodes to be removed from current node
    * @param d        - to avoid compilation error caused by type erasure
    * @return - new element without the specified children
    */
  def remove(children: Set[Element])(implicit d: DummyImplicit): Element =
    Element(name, attributes, elements -- children, value)

  /**
    *
    * @param old     - node to be updated
    * @param updated - updated node
    * @return - element with the old element updated
    */
  def edit(old: Element, updated: Element): Element =
    Element(name, attributes, elements - old + updated, value)

  /**
    *
    * @param old     - attribute to be updated
    * @param updated - updated attribute
    * @return - element with the old attribute updated
    */
  def edit(old: Attribute, updated: Attribute): Element =
    Element(name, attributes - old + updated, elements, value)

  /**
    *
    * @param newValue - new value for, what is essentially, the leaf
    * @return - element with the updated leaf
    */
  def edit(newValue: Option[Value]): Element =
    Element(name, attributes, elements, newValue)
}


case class Attribute(name: String, value: String) extends XMLNodeDetails {
  override def toXml: String = s""" $name = "$value""""
}


case class Value(value: String) extends XMLNodeDetails {
  override def toXml: String = s"$value"
}

