import xml.{Attribute, Element, Value}

object Main extends App{
  println(Element("people",
    elements = Set(Element("person",
      elements = Set(Element("PassionAttr", Set(Attribute("weight", "15")), Set.empty, Some(Value("guitar"))),
        Element("AgeAttr", Set(Attribute("weight", "20")), Set.empty, Some(Value("25")))))),
    value = None).toXml(0))
}
