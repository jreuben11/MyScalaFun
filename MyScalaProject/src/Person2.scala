// 4.3. Defining Auxiliary Constructors
case class Person2 (var name: String, var age: Int)
object Person2 {
  def apply() = new Person2("<no name>", 0) 
}

