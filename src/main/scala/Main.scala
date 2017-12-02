import xml.io.Writer
import xml.{Attribute, Element, Value}

object Main extends App{
  println(Writer.save(Element("people",
    elements = Set(Element("person",
      elements = Set(Element("PassionAttr", Set(Attribute("weight", "15")), Set.empty, Some(Value("guitar"))),
        Element("AgeAttr", Set(Attribute("weight", "20")), Set.empty, Some(Value("25")))))),
    value = None), "asdfasdfa\\out.xml"))
}
