// 12.7. Using Serialization

// create a serializable Stock class
@SerialVersionUID(123L)
class Stock(var symbol: String, var price: BigDecimal) extends Serializable { 
  override def toString = f"$symbol%s is ${price.toDouble}%.2f" 
} 