// note ctor is the class decleration, accessors are initialized
class MyComplexClass(real: Double, imaginary: Double) {
  def re() = real
  def im() = imaginary
  
  // overide AnyRef base class
  override def toString() = "" + re + (if (im < 0) "" else "+") + im + "i"
}