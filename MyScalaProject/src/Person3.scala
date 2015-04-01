// 4.4 Singleton
class Person3 private  {}
object Person3 {
  val p = new Person3
  def getInstance = p
}