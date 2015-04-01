package MyPackage

// 6.4. Launching an Application with an Object
object Entry extends App {
  if (args.length >= 1) 
    println(s"Hello, ${args(0)}") 
  else 
    println("Entry")
    
  // 6.7. Putting Common Code in Package Objects  
  echo(MAGIC_NUM) 
  echo(Margin.LEFT) 
  // use our MutableMap type (scala.collection.mutable.Map)
  val mm = MutableMap("name" -> "Al")
  mm += ("password" -> "123")
  for ((k,v) <- mm) printf("key: %s, value: %s\n", k, v) 
}