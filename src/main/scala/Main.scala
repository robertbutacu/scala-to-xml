import xml.{Attribute, Element, Value}

object Main extends App{
  println(Element("people",
    elements = Set(Element("person",
      elements = Set(Element("PassionAttr", Set(Attribute("weight", "15")), Set.empty, Some(Value("guitar")))))),
    value = None).toXml(0))
}
