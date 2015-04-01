import java.util.{Date, Locale}  // specify classes in a namespace
import java.text.DateFormat
import java.text.DateFormat._    // like *

object JavaInterop {
  def callJava(){
    val now = new Date()  // immutable
    val df = getDateInstance(LONG, Locale.CHINESE)
    println(df format now)  // df.format(now)  - Methods taking one arg can be used with infix syntax
  }
}