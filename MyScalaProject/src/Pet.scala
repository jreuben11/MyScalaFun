// 4.13. Defining Properties in an Abstract Base Class (or Trait) 
abstract class Pet (name: String) {
  val greeting: String = "BLAH"
  var age: Int
  def sayHello { println(greeting) }
  override def toString = s"I say $greeting, and I'm $age" 
} 

class Dog (name: String) extends Pet (name)  with Animal2 { 
  override val greeting = "Woof"
  final var age = 2 
} 

class Cat (name: String) extends Pet (name)  with Animal2 { 
  override val greeting = "Meow"
  final var age = 5 
} 

// 10.5. Declaring a Type When Creating a Collection
trait Animal2
trait FurryAnimal extends Animal2

class AnimalKingdom {
  val d = new Dog("Fido")
  val c = new Cat("Felix")
  def animals = Array[Animal2](d, c) 
} 
