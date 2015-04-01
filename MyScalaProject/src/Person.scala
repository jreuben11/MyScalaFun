// 4.1. Creating a Primary Constructor
// 4.5. Providing Default Values for Constructor Parameters
class Person(var firstName: String, var lastName: String, var id: Int = 10) extends Ordered [Person] { 
  println("the constructor begins") 
 
  // some class fields
  private val HOME = System.getProperty("user.home") 
  var age = 0 
  // 4.8. Assigning a Field to a Block or Function
  lazy val reverse = { 
    lastName.reverse
  }
  // 4.9. Setting Uninitialized var Field Types
  var address = None: Option[Address] 
  
  // some methods
  override def toString = s"$firstName $lastName is $age years old" 
  def printHome { println(s"HOME = $HOME") }
  def printFullName { println(this) } // uses toString 
  
  printHome
  printFullName
  println("still in the constructor")
  
  // 4.3 Defining Auxiliary Constructors
  def this() {
    this(Person.DEFAULT_NAME, Person.DEFAULT_NAME)
  }
  
  // 10.28. Sorting a Collection
  def compare (that: Person) = { 
    if (this.lastName == that.lastName) 0 
    else if (this.lastName > that.lastName) 1 
    else -1
  } 
} 
object Person {
   val DEFAULT_NAME = "blah"
}
case class Address(city: String, state: String, zip: String) 