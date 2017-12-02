package xml.io

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import xml.Element

import scala.util.Try

object Writer {
  def save(root: Element, filename: String): Try[Unit] = {
    val rootSerialized = root.toXml()
    Try {
      val output = new BufferedWriter(new FileWriter(new File(filename)))

      output.write(rootSerialized)
      output.close()
    }
  }
}
