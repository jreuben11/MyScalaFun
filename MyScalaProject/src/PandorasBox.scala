class PandorasBox {
  case class Thing (name: String) 
  var things = new collection.mutable.ArrayBuffer[Thing]() 
  things += Thing("Evil Thing #1")
  things += Thing("Evil Thing #2") 
  def addThing(name: String) { 
    things += new Thing(name) 
  } 
}