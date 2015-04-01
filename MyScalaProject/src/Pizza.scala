// 6.6. Creating Static Members with Companion Objects

// Pizza class
class Pizza  (var crustType: String) extends PizzaTrait {
  override def toString = "Crust type is " + crustType 
  // trait fields: 
  var numToppings = 0 //var abstract - 'override' not needed ; 
  size = 16 
  override val minNumToppings = 10  // val abstract - override needed
} 

// companion object
object Pizza {
  val CRUST_TYPE_THIN = "thin" 
  val CRUST_TYPE_THICK = "thick" 
  def getFoo = "Foo" 
} 

// 8.2. Using Abstract and Concrete Fields in Traits
trait PizzaTrait {
  var numToppings: Int // abstract 
  var size = 14 // concrete 
  val minNumToppings : Int // abstract
  val maxNumToppings = 10 // concrete  
} 