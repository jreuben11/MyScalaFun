package blah.utils  // must be in a specified package, not default !!!

object MyExtensionsObject{
  implicit class MyStringExtensions(s: String) {
    def increment: String = s.map(c => (c + 1).toChar) 
    
    @throws(classOf[NumberFormatException]) // required for Java clients
    def toInt(radix: Int): Int = Integer.parseInt(s, radix) 
    /*
    def toInt2(s: String):Option[Int] = { 
      try { 
        //s.toInt(2)
        Some(s.toInt2) 
      } catch { 
        case e: NumberFormatException => None 
      } 
     } 
    */
  }
  
  import scala.annotation.tailrec 
  @tailrec 
  def whilst(testCondition: => Boolean)(codeBlock: => Unit) { 
    if (testCondition) { 
      codeBlock 
      whilst(testCondition)(codeBlock)
    }
  } 
}