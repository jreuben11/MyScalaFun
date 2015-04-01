


/**
 * @author joshr
 */
// compile:    scalac Quickstart.scala
// run:        scala -classpath . Quickstart
object Quickstart {
  def main(args: Array[String]) {
    println("Begin")
    
    // TimerCallback.oncePerSecond { () => println("from ananonymous function") }
    
    // val o = new MyComplexClass(1.2, 3.4)
    // println("imaginary part: " + o.im())
    // basicArrays()
    
    // 1 strings()
    // 2 numbers()
    // 3 controlStructures()
    // 4 classes()
    // 6 objects()
    // 9 FP()
    // 10
    collections()
    
    println("\nEnd")
  }
  
  def collections() {
    // 10.1. Understanding the Collections Hierarchy
    val v = Vector(1, 2, 3) 
    v.sum // 6
    v.filter(_ > 1) // Vector(2, 3)
    v.map(_ * 2)  // Vector(2, 4, 6)
    
    val x = IndexedSeq(1,2,3)
    val seq = scala.collection.immutable.LinearSeq(1,2,3) 
    val m = Map(1 -> "a", 2 -> "b")
    val m2 = collection.mutable.Map(1 -> "a", 2 -> "b")
    val set = Set(1, 2, 3)
    
    
    // 10.4. Understanding the Performance of Collections
    var v2 = Vector[Int]()
    for (i <- 1 to 50000) v2 = v2 :+ i 
    
    // 10.5. Declaring a Type When Creating a Collection
    val x2 = List[Number](1, 2.0, 33D, 400L)
    val x3 = List[AnyVal](1, 2.0, 33D, 400L) 
    
    // 10.6. Understanding Mutable Variables with Immutable Collections
    var sisters = Vector("Melinda")
    sisters = sisters :+ "Melissa"
    sisters = sisters :+ "Marisa"
    
    // 10.7. Make Vector Your “Go To” Immutable Sequence 
    var a = Vector(1, 2, 3)
    a(0)
    val b = a ++ Vector(4, 5)
    var c = b.updated(0, "x")
    c = a.take(2)
    c = a.filter(_ > 2)
    a = a ++ Vector(4, 5)
    
    // 10.8. Make ArrayBuffer Your “Go To” Mutable Sequence
    import scala.collection.mutable.ArrayBuffer 
    var nums = ArrayBuffer(1, 2, 3)
    nums += 4
    nums += (5, 6)
    nums ++= List(7, 8)
    nums -= (7, 8)
    nums --= Array(5, 6)
    
    val aa = ArrayBuffer.range('b', 'h')
    aa.prepend('a')
    
    // 10.9. Looping over a Collection with foreach
    "HAL".foreach((c: Char) => println(c)) 
    
    val longWords = new StringBuilder 
    "Hello world it's Al".split(" ").foreach{ 
      word => if (word.length > 4) longWords.append(s" $word") 
      else println("Not added: " + word) 
    } 
    
    m foreach (kvp => println(s"${kvp._1} -> ${kvp._2}")) 
    m.foreach { case(key, value) => println(s"key: $key, value: $value")  } 
    
    // 10.10. Looping over a Collection with a for Loop
    val fruits = Vector("apple", "banana", "orange") 
    for (f <- fruits) println(f)
    for (i <- 0 until fruits.size) println(s"element $i is ${fruits(i)}")
    for ((elem, count) <- fruits.zipWithIndex) { 
      println(s"element $count is $elem")
    } 
    for ((elem,count) <- fruits.zip(Stream from 1)) { 
      println(s"element $count is $elem")
    }
    for (i <- 1 to 3) println(i)
    val bigFruits = for (e <- fruits) yield e.toUpperCase
    for {f <- fruits if f.startsWith("b") if f.endsWith("a") } println(f)
    
    // 10.11. Using zipWithIndex or zip to Create Loop Counters
    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday") 
    days.zipWithIndex.view.foreach {
      case(day, count) => println(s"$count is $day") 
    } 
    
    // 10.12. Using Iterators
    // 10.13. Transforming One Collection to Another with for/ yield 
    // 10.14. Transforming One Collection to Another with map
    val fruitsList = "apple" :: "banana" :: "orange" :: Nil
    var caps = fruitsList.map(e => e.capitalize)
    caps = fruitsList.map(_.capitalize)
    val elems = fruitsList.map(fruit => <li>{fruit}</li>)
    def plusOne(c: Char): Char = (c.toByte+1).toChar 
    "HAL".map(plusOne)
    "HAL".map((c: Char) => (c.toByte+1).toChar ).foreach { println }
    val s = " eggs, milk, butter, Coco Puffs "
    val items = s.split(",").map(_.trim)
    
    // 10.15. Flattening a List of Lists with flatten
    val lol = List(List(1,2), List(3,4)).flatten
    val adamsFriends = List("Nick K", "Bill M")
    val davidsFriends = List("Becca G", "Kenny D", "Bill M") 
    import scala.collection.mutable.ListBuffer 
    val uniqueFriendsOfFriends = ListBuffer(adamsFriends, davidsFriends).flatten.distinct.sorted
    val charList = List("Hello", "world").flatten
    val vals = Vector(Some(1), None, Some(3), None).flatten  // Vector(1, 3) 
    
    // 10.16. Combining map and flatten with flatMap
    val bag = List("1", "2", "three", "4", "one hundred seventy five")
    def toInt(in: String): Option[Int] = { 
      try {Some(Integer.parseInt(in.trim)) } 
      catch {  case e: Exception => None } 
    } 
    bag.flatMap(toInt).sum //7
    
    // 10.18. Extracting a Sequence of Elements from a Collection
    var nums2 = (1 to 10).toArray 
    nums2.drop(3)
    nums2.dropWhile(_ < 6)
    nums2.dropRight(4)
    nums2.take(3)
    nums2.takeWhile(_ < 5)
    nums2.takeRight(3)
    nums2 = (1 to 5).toArray 
    nums2.head     // 1
    nums2.headOption   // Some(1)
    nums2.init     // Array(1, 2, 3, 4)
    nums2.last     // 5
    nums2.lastOption   // Some(5)
    nums2.tail     // Array(2, 3, 4, 5)
    val peeps = List("John", "Mary", "Jane", "Fred") 
    peeps.slice(1,3)  // List(Mary, Jane) 
    
    // 10.19. Splitting Sequences into Subsets (groupBy, partition, etc.)
    val x4 = List(15, 10, 5, 8, 20, 12) 
    val groups = x4.groupBy(_ > 10)
    val trues = groups(true)
    val falses = groups(false)
    val y2 = x4.partition(_ > 10)
    val (a1,b1) = x.partition(_ > 10)
    val y3 = x4.span(_ < 20)
    val y4 = x4.splitAt(2)
    
    nums2.sliding(2,2).toList
    val couples = List(("Wilma", "Fred"), ("Betty", "Barnie"))
    val (women, men) = couples.unzip
    val couples2 = women zip men
    
    // 10.20. Walking Through a Collection with the reduce and fold Methods
    val findMax = (x: Int, y: Int) => {
      val winner = x max y
      println(s"compared $x to $y, $winner was larger") 
      winner 
    } 
    val a2 = Array(12, 6, 15, 2, 20, 9) 
    a2.reduceLeft(findMax)
    peeps.reduceLeft((x,y) => if (x.length > y.length) x else y)  //longest
    peeps.reduceLeft((x,y) => if (x.length < y.length) x else y) // shortest
    
    val a3 = Array(1, 2, 3)
    a3.reduceLeft(_ + _) // 6
    a3.foldLeft(100)(_ + _) // 106
    
    val product = (x: Int, y: Int) => {
      val result = x * y
      println(s"multiplied $x by $y to yield $result") 
      result 
    }
    a3.scanLeft(10)(product)
    
    // 10.24. Creating a Lazy View on a Collection
    val view = (1 to 100).view
    view.force
    
    // 10.26. Creating and Using Enumerations
    object Margin extends Enumeration { 
      type Margin = Value // is this necessary ?
      val TOP, BOTTOM, LEFT, RIGHT = Value 
    } 
    var currentMargin = Margin.TOP // later in the code ... 
    if (currentMargin == Margin.TOP) println("working on Top") 
    
    // 10.27. Tuples, for When You Just Need a Bag of Things 
    val tupleA = (3, "Three", new Person("Al", "Bundy"))
    val (t1,t2,t3) = tupleA
    val t1b = tupleA._1
    val (_,t2b,_) = tupleA
    var tupleB = ("AL", "Alabama")
    tupleB = "AL" -> "Alabama"
    tupleB = ("AL" -> "Alabama")
   
    // 10.28. Sorting a Collection
    var sortedFruits = fruits.sorted
    sortedFruits = fruits.sortWith(_ < _)
    sortedFruits = fruits.sortWith(_.length > _.length)
    
    // 10.29. Converting a Collection to a String with mkString
    println (fruits.mkString(", "))
    
    var l = List.range(1, 10)
    l = List.range(0, 10, 2)
    var l2 = List.fill(3)("foo")
    l = List.tabulate(5)(n => n * n) 
    
    // 11.2. Creating a Mutable List
    var fruits2 = new ListBuffer[String]() 
    // add one element at a time to the ListBuffer
    fruits2 += "Apple"
    fruits2 += "Banana"
    fruits2 += "Orange"
    // add multiple elements
    fruits2 += ("Strawberry", "Kiwi", "Pineapple") // remove one element 
    fruits2 -= "Apple"
    // remove multiple elements 
    fruits2 -= ("Banana", "Orange")
    // remove multiple elements specified by another sequence 
    fruits2 --= Seq("Kiwi", "Pineapple")
    // convert the ListBuffer to a List when you need to 
    val fruitsList2 = fruits2.toList 
    
    val fruitsList3 = "grapes" :: fruitsList2
    val fruitsList4 = "lemons" :: fruitsList3 
    
    // 11.3. Adding Elements to a List 
    class Printer {
      def >>(i: Int) { println(s"$i") } 
      def >>:(i: Int) { println(s"$i") } 
    } 
    val f1 = new Printer
    f1.>>(42)
    f1 >> 42
    42 >>: f1 
    
    // 11.6. Using Stream, a Lazy Version of a List
    val stream = 1 #:: 2 #:: 3 #:: Stream.empty
    
    // 11.11. Creating Multidimensional Arrays
    val xx, yy, zz = 3
    val aaa = Array.ofDim[Int](xx,yy,zz) 
    for { 
      i <- 0 until xx 
      j <- 0 until yy 
      k <- 0 until zz 
    } println(s"($i)($j)($k) = ${aaa(i)(j)(k)}")
    
    
  }
  
  def FP(){
    // 9.1. Using Function Literals (Anonymous Functions)
    val l = List.range(1, 10) 
    var evens = l.filter((i: Int) => i % 2 == 0)
    // shorthand:
    evens = l.filter(_ % 2 == 0)
    l.foreach((i:Int) => println(i))
    l.foreach(i => println(i))
    l.foreach(println(_)) 
    l.foreach(println)
    
    // 9.2. Using Functions as Variables 
    val double = (i: Int) => i * 2 
    val d = double(5)
    val dl = l.map(double)
    
    var f: (Int) => Boolean = i => { i % 2 == 0 } 
    f = (i: Int) => { i % 2 == 0 } 
    // shorthand
    f = i =>  i % 2 == 0
    f(5)  // false
    
    // Using a method like an anonymous function
    def modMethod(i: Int): Boolean = { i % 2 == 0 }
    def modMethod2(i: Int) = i % 2 == 0
    
    // Assigning an existing function/method to a function variable 
    var c = scala.math.cos(_)
    c = scala.math.cos _
    c(0)
    val pw = scala.math.pow(_, _)
    
    
    // 9.3. Defining a Method That Accepts a Simple Function Parameter 
    // 9.4. More Complex Functions
    def executeFunction(callback :(String) => Unit, s: String) { callback(s) } 
    val sayHello = (s: String) => { println("Hello callback " + s) }
    executeFunction(sayHello, "blah")
    
    // 9.5. Using Closures
    var hello = "Hello"
    def sayHello2(name: String) { println(s"$hello, $name") }
    sayHello2("BLAH")
    hello = "BONJOUR"
    sayHello2("BLAH")
    
    // 9.6. Using Partially Applied Functions
    val sum = (a: Int, b: Int, c: Int) => a + b + c 
    val fsum = sum(1, 2, _: Int)
    fsum(3)
    
    def wrap(prefix: String, html: String, suffix: String) = { 
      prefix + html + suffix
    }
    val wrapWithDiv = wrap("<div>", _: String, "</div>")
    wrapWithDiv("<p>Hello, world</p>") 
    wrapWithDiv("<img src=\"/images/foo.png\" />") 
    
    
    // 9.7. Creating a Function That Returns a Function
    def saySomething(prefix: String) : String => String = {
      val f :(String) => String = s => {prefix + " " + s }
      return f
    }
    // shorthand
    def saySomething2(prefix: String) = (s: String) => prefix + " " + s 
    val sayHello3 = saySomething2 ("Hello")
    sayHello3 ("World")
    
    def greeting(language: String) = (name: String) => { 
      val english = () => "Hello, " + name
      val spanish = () => "Buenos dias, " + name 
      language match { 
        case "english" => {
          println("returning 'english' function") 
          english() 
        }
        case "spanish" => {
          println("returning 'spanish' function") 
          spanish() 
        }
      } 
    } 
    val hello5 = greeting("english")
    
    // 9.8. Creating Partial Functions
    val divide = new PartialFunction[Int, Int] { 
      def apply(x: Int) = 42 / x 
      def isDefinedAt(x: Int) = x != 0 
    } 
    if (divide.isDefinedAt(1)) divide(1)
    
    // collect works with PartialFunction
    val l2 = List(0,1,2) collect { divide }   // 42,21
    List(42, "cat") collect { case i: Int => i + 1 } 
    val el = for { e <- l2 if e % 2 == 0 } yield e // same as filter
  }
  
  
  def objects() = {
    
    // 6.1 object casting
    // cast Array[Any] to java compatabile Array[Object]
    val objects = Array("a", 1)
    val arrayOfObject = objects.asInstanceOf[Array[Object]] 
    // canonical connection cast
    import java.net.{URL, HttpURLConnection} 
    val connection = (new URL("http://blah")).openConnection.asInstanceOf[HttpURLConnection] 
    
    //6.2 The Scala Equivalent of Java’s .class Problem
    val stringClass = classOf[String] 
    
    // 6.3. Determining the Class of an Object
    def printAll(numbers: Int*) { 
      println("class: " + numbers.getClass) 
    } 
    printAll()
    printAll(1, 2, 3)
    // add external jar from: /usr/local/Cellar/scala/2.11.4/libexec/lib
    val hello2 = <p>Hello, <br/>world</p>
    hello2.child.foreach(e => println(e.getClass))  
    
    
    // 6.5. Creating Singletons with object 
    object CashRegister {
      def open { println("opened") } 
      def close { println("closed") } 
    } 
    CashRegister.open
    
    import java.util.Calendar
    import java.text.SimpleDateFormat
    object DateUtils {
      // as "Thursday, November 29" 
      def getCurrentDate: String = getCurrentDateTime("EEEE, MMMM d") 
      // as "6:20 p.m." 
      def getCurrentTime: String = getCurrentDateTime("K:m aa") 
      // a common function used by other date/time functions
      private def getCurrentDateTime(dateTimeFormat: String): String = { 
        val dateFormat = new SimpleDateFormat(dateTimeFormat)
        val cal = Calendar.getInstance() 
        dateFormat.format(cal.getTime()) 
      } 
    }  
    DateUtils.getCurrentDate
    
    // 6.6. Creating Static Members with Companion Objects
    var p = new Pizza(Pizza.CRUST_TYPE_THICK) 
    println(p) 
    
    object StringUtils {
      def increment(s: String) = s.map(c => (c + 1).toChar) 
    } 
    println (StringUtils.increment("HAL"))
  }

  def classes() = {
    // 4.1 
    val p = new Person("Adam", "Meyer")
    p.firstName = "Scott" 
    p.lastName = "Jones" 
    println(p)
    
    // 4.3 auxillary ctors, 
    // 6.8. Creating Object Instances Without Using the new Keyword
    val p2 = Person2("blah", 5) // no need for new with case class instances
    val p3 = Person2()
    println(p3)
    
    // 4.4 singleton
    val p4 = Person3.getInstance
    
    // 4.5 default params
    val p5 = new Person
    println(p5.id)
    
    //4.8. Assigning a Field to a Block or Function
    p.lastName = "Reuben"
    println(p.reverse)
    
    // 4.9. Setting Uninitialized var Field Types
    println(p.address )
    p.address = Some(Address("Talkeetna", "AK", "99676")) 
    println(p.address )
    println(p.address.exists { x => x.city=="Talkeetna" } )
    
    // 4.13. Defining Properties in an Abstract Base Class (or Trait) 
    val dog = new Dog("Fido")
    val cat = new Cat("Morris") 
    dog.sayHello
    cat.sayHello
    println(dog)
    println(cat)
  }
  
  def strings() = {
    println ("Hello, world".getClass.getName)      // class name
    "hello".foreach(println)                       // string to char array
    for (c <- "hello") println(c)                  // same
    val s = "Hello" + " world" 
    s.getBytes.foreach(println)                    // string to byte array  
    println ("scala".drop(2).take(2).capitalize)   // fluent char array manipulation - both collection and string methods    
   
    // 1-1 Testing String Equality
    println("blah".equalsIgnoreCase("BLAH"))       // compare strings ignoring case
    
    // 1-2 Creating Multiline Strings
    val speech = """Four score and |seven years ago""".stripMargin   // didnt work !
    
    // 1-3 spliting a string
    val arr1 = "eggs, milk, butter, Coco Puffs".split(",").map(_.trim)
    
    // 1-4 string substitution - NICE
    val name = "Fred"
    val age = 33 
    val weight = 200.00 
    println(s"$name is ${age + 1} years old, and weighs $weight pounds.")   //s - $<varname> - supports expressions
    println(f"$name is $age years old, and weighs $weight%.2f pounds.")    //f
    println (raw"foo\nbar")    // raw
    
    // 1-5. Processing a String One Character at a Time
    "hello, world".filter(_ != 'l').map(_.toUpper).foreach (print)
    
    // 1.6. Finding Patterns in Strings
    "[0-9]+".r.findAllIn("123 Main Street Suite 101").foreach (print)    // r creates a Regex
    val rmatch = "[0-9]+".r.findFirstIn("blah")    // an Option
    println(rmatch.getOrElse("no match") )
    rmatch match {
      case Some(s) => println(s"Some $s")
      case None => // no-op
    }
    
    // 1.7. Replacing Patterns in Strings
    val address = "123 Main Street".replaceAll("[0-9]", "x") // regex replaceAll instead of findAll
    
    // 1.8. Extracting Parts of a String That Match Patterns
    // WEIRD: looks like we are defining pattern twice
    val pattern = "([0-9]+) ([A-Za-z]+)".r
    val pattern(count, fruit) = "100 Bananas"   // count: String = 100 fruit: String = Bananas 
    
    
    // this technique - in each case applies a Regex(out String) against the input to match
    val MoviesZipRE = "movies (\\d{5})".r   // match "movies 80301"
    val MoviesNearCityStateRE = "movies near ([a-z]+), ([a-z]{2})".r // match "movies near boulder, co" 
    "textUserTyped" match {
      case MoviesZipRE(zip) => // getSearchResults(zip)
      case MoviesNearCityStateRE(city, state) => // getSearchResults(city, state) 
      case _ => println("did not match a regex") 
    } 
    
    // 1.9. Accessing a Character in a String
    println( "hello"(3) ) // access char at 4th index
    
    // 1.10. Add Your Own Methods to the String Class
    import blah.utils.MyExtensionsObject._
    println("HAL".increment)
  }
  
  def numbers() = {
    // 2.1. Parsing a Number from a String
    "100".toDouble
    
    import blah.utils.MyExtensionsObject._
    "100".toInt(2)  // 4
    "100".toInt(16)  // 256
    
    // 2.2. Converting Between Numeric Types (Casting)
    if (19.45.isValidInt) 19.45.toInt
    19.toFloat
    
    // 2.3. Overriding the Default Numeric Type 
    val a = 1000L
    val c = 0: Short
    
    // 2.4. Replacements for ++ and −−
    var x = 0
    x += 1
    
    // 2.5 Comparing Floating-Point Numbers
    ~=(0.1, 0.3, 0.0001)
    
    // 2.6. Handling Very Large Numbers
    var b = BigDecimal(123456.789)
    1.7976931348623157E308 > Double.PositiveInfinity
    
    // 2.7. Generating Random Numbers
    val r = scala.util.Random
    r.setSeed(50L) 
    r.nextInt(100) // can limit range to max value
    r.nextDouble()
    r.nextPrintableChar
    
    // 2.8. Creating a Range.Inclusive, List, or Array of Numbers
    var range1 = 0 to r.nextInt(10) // a random length range
    val range2 = 1 to 10
    val range3 = 1 to 10 by 2
    for (i <- 1 until 5) println(i)
    range1.toList
    range1.toArray
    val l = (1 to 10).toList
    val g = for (i <- 1 to 5) yield i * 2  // an IndexedSeq
    
    // 2.9. Formatting Numbers and Currency
    val pi = scala.math.Pi
    println(f"$pi%1.5f") //3.14159
    val formatter = java.text.NumberFormat.getIntegerInstance
    formatter.format(1000000) // res1: String = 1,000,000 
    
  }
  
  def ~=(x: Double, y: Double, precision: Double) = { 
    if ((x - y).abs < precision) true 
    else false 
   } 
   
  def controlStructures() = {
    val x = if (true) 1 else 0  // no need for terniery 
    val nieces = List("emily", "hannah", "mercedes", "porsche")
    val names = for (n <- nieces) yield n.capitalize
    // NICE- for comprehension - instead of 2 nested loops
    for { 
      name <- names ;
      char <- name ;
      if char.isUpper 
    } print(char)
    
 
    //3.1. Looping with for and foreach
    val a = Array("apple", "banana", "orange")
    for (e <- a) println(e)
    for (e <- a) {
     val s = e.toUpperCase
     println(s)
    } 
    val newArray = for (e <- a) yield e.toUpperCase
    for (i <- 0 until a.length) { 
      println(s"$i is ${a(i)}") 
    } 
    for ((e, count) <- a.zipWithIndex) {   // create a loopcounter
      println(s"$count is $e")
    } 
    for (i <- 1 to 10 if i < 4) println(i)  // condition contains a guard
    
    val kvps = Map("fname" -> "Robert", "lname" -> "Goren") // iterate over a map
    for ((k,v) <- kvps) println(s"key: $k, value: $v")
    
    a.foreach(println)
    
    
    // 3.2. Using for Loops with Multiple Counters
    for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")  //will print 4 lines
    for {i <- 1 to 2; j <- 1 to 2} println(s"i = $i, j = $j")  //same. preffered style
    
    val arr = Array.ofDim[Int](2,2) // create a 2x2 array
    arr(0)(0) = 5    // indexers
    for {i <- 0 to 1; j <- 0 to 1} println(s"($i)($j) = ${arr(i)(j)}") 
    
    // 3.3. Using a for Loop with Embedded if Statements (Guards)
    for (i <- 1 to 10 if i % 2 == 0) println(i)
    
    // 3.4. Creating a for Comprehension (for/yield Combination)
    val capNames = for (e <- names) yield e.capitalize  // collection type will be the same
    
    // 3.5. Implementing break and continue 
    import util.control.Breaks._
    breakable {
      for (i <- 1 to 10) {
        println(i)
        if (i > 4) break // break out of the for loop 
      } 
    } 
    
    import scala.annotation.tailrec
    def factorial(n: Int): Int = {
      @tailrec def factorialAcc(acc: Int, n: Int): Int = { //nested function
        if (n <= 1) acc 
        else factorialAcc(n * acc, n - 1) // recursive call
      } 
      factorialAcc(1, n)
    }
    val fact = factorial(5)
    println (s"factorial $fact")
    
    // 3.6. Using the if Construct Like a Ternary Operator 
    def abs(x: Int) = if (x >= 0) x else -x
   
    // 3.7. Using a Match Expression Like a switch Statement
    import scala.annotation.switch
    val i = 1
    val month = (i: @switch) match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case _ => "Invalid"
    }
    
     // 3.8. Matching Multiple Conditions with One Case Statement 
    val j = 5 
    j match { 
      case 1 | 3 | 5 | 7 | 9 => println("odd") 
      case 2 | 4 | 6 | 8 | 10 => println("even") 
      } 
  
    // 3.11. Using Pattern Matching in Match Expressions
    case class Person(firstName: String, lastName: String) 
    case class Dog(name: String) 
    def echo(x: Any): String = x match { 
      // constant patterns
      case 0 => "zero"
      case true => "true"
      case "hello" => "you said 'hello'" 
      case Nil => "an empty List" 
            // sequence patterns
      case List(0, _, _) => "a three-element list with 0 as the first element"
      case List(1, _*) => "a list beginning with 1, having any number of elements" 
      case Vector(1, _*) => "a vector starting with 1, having any number of elements" 
       // ADD A VARIABLE TO A PATTERN
      // case list @ List(2, _*) => s"$list"
      // tuples 
      case (a, b) => s"got $a and $b"
      case (a, b, c) => s"got $a, $b, and $c" 
            // constructor patterns - PROBLEMATIC !
      //case Person(first, "Alexander") => s"found an Alexander, first name = $first" 
      //case Dog("Suka") => "found a dog named Suka" 
            // typed patterns
      case s: String => s"you gave me this string: $s"
      case i: Int => s"thanks for the int: $i"
      case f: Float => s"thanks for the float: $f"
      case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
      case as: Array[String] => s"an array of strings: ${as.mkString(",")}" 
      //case d: Dog => s"dog: ${d.name}"
      case list: List[_] => s"thanks for the List: $list" 
      case m: Map[_, _] => m.toString 
      case _ => "Unknown" // the default wildcard pattern
    } 
   
    object LargeMatchTest extends App {    
      // trigger the constant patterns
      
      println(echo(0)) 
      println(echo(true)) 
      println(echo("hello")) 
      println(echo(Nil)) 
      // trigger the sequence patterns
      println(echo(List(0,1,2))) 
      println(echo(List(1,2))) 
      println(echo(List(1,2,3))) 
      println(echo(Vector(1,2,3))) 
      // trigger the tuple patterns
      println(echo((1,2)))  // two element tuple
      println(echo((1,2,3)))  // three element tuple
      // trigger the constructor patterns
      
     // println(echo(Person("Melissa", "Alexander"))) 
      // println(echo(Dog("Suka"))) 
      
      // trigger the typed patterns
      println(echo("Hello, world")) 
      println(echo(42)) 
      println(echo(42F)) 
      println(echo(Array(1,2,3))) 
      println(echo(Array("coffee", "apple pie"))) 
      //println(echo(Dog("Fido"))) 
      println(echo(List("apple", "banana"))) 
      println(echo(Map(1->"Al", 2->"Alexander"))) 
      // trigger the wildcard pattern
      println(echo("33d"))
     
    } 
   
    object Test2 extends App { 
      def matchType(x: Any): String = x match {
        //case x: List(1, _*) => s"$x" // doesn't compile 
        case x @ List(1, _*) => s"$x" // works; prints the list 
        //case Some(_) => "got a Some" // works, but can't access the Some 
        //case Some(x) => s"$x" // works, returns "foo"
        case x @ Some(_) => s"$x" // works, returns "Some(foo)" 
        //case p @ Person(first, "Doe") => s"$p" // returns "Person(John,Doe)" 
      } 
      println(matchType(List(1,2,3))) // prints "List(1, 2, 3)"
      println(matchType(Some("foo"))) // prints "Some(foo)"
      //println(matchType(Person("John", "Doe"))) // prints "Person(John,Doe)" 
    } 
  
    def toInt(s: String): Option[Int] = { 
      try { 
        Some(Integer.parseInt(s.trim)) 
      } catch { 
        case e: Exception => None 
      } 
    }
    toInt("42") match {
      case Some(i) => println(i)
      case None => println("That wasn't an Int.") 
    }
  
    // 3.12. Using Case Classes in Match Expressions
    /*
    trait Animal
    case class Worg(name: String) extends Animal 
    case class Cat(name: String) extends Animal 
    case object Woodpecker extends Animal 
    
    object CaseClassTest extends App { 
      def determineType(x: Animal): String = x match {
        case Worg(moniker) => "Got a Worg, name = " + moniker 
        case _:Cat => "Got a Cat (ignoring the name)"
        case Woodpecker => "That was a Woodpecker"
        case _ => "That was something else" 
      } 
      println(determineType(new Worg("Rocky"))) 
      println(determineType(new Cat("Rusty the Cat"))) 
      println(determineType(Woodpecker)) 
    } 
    * 
    */
    
    // 3.13. Adding if Expressions (Guards) to Case Statements
    i match {
      case a if 0 to 9 contains a => println("0-9 range: " + a) 
      case b if 10 to 19 contains b => println("10-19 range: " + b) 
      case c if 20 to 29 contains c => println("20-29 range: " + c) 
      case _ => println("Hmmm...") 
    } 
    i match {
      case x if x == 1 => println("one, a lonely number") 
      case x if (x == 2 || x == 3) => println(x)
      case _ => println("some other value") 
    } 
    /*
    def speak(p: Person) = p match {
      case Person(name) if name == "Fred" => println("Yubba dubba doo") 
      case Person(name) if name == "Bam Bam" => println("Bam bam!") 
      case _ => println("Watch the Flintstones!") 
    } 
    * 
    */
    
    // 3.15. Working with a List in a Match Expression
    val l1 = List(1, 2, 3)
    val l2 = 1 :: 2 :: 3 :: Nil // alternative form
    
    // recursive function: NOT EXACTLY SURE HOW IT IS GOING TO NEXT
    def listToString(list: List[String]): String = list match { 
      case s :: rest => s + " " + listToString(rest)
      case Nil => "" 
    } 
    val fruits = "Apples" :: "Bananas" :: "Oranges" :: Nil 
    println(fruits.mkString)
    println( listToString(fruits) )
    
    def sum(list: List[Int]): Int = list match { 
      case Nil => 1
      case n :: rest => n + sum(rest) 
    } 
    def multiply(list: List[Int]): Int = list match { 
      case Nil => 1
      case n :: rest => n * multiply(rest) 
    } 
    val nums = List(1,2,3,4,5)
    sum(nums)
    multiply(nums)
    
    // 3.16. Matching One or More Exceptions with try/catch
    val s = "Foo" 
    try { 
      val i = s.toInt 
    } catch { 
      case e: Exception => e.printStackTrace 
      case _: Throwable => println("exception ignored") 
    } 
    
    @throws(classOf[NumberFormatException]) 
    def toInt2(s: String): Option[Int] = try { 
      Some(s.toInt) 
    } catch {
      case e: NumberFormatException => throw e    
    } 
    
    // 3.17. Declaring a Variable Before Using It in a try/catch/  finally Block
    import java.io._
    object CopyBytes extends App { 
      var in = None: Option[FileInputStream] 
      var out = None: Option[FileOutputStream] 
      try {
        in = Some(new FileInputStream("/tmp/Test.class"))
        out = Some(new FileOutputStream("/tmp/Test.class.copy")) 
        var c = 0
        while ({c = in.get.read; c != -1}) { 
          out.get.write(c)
        }
      } catch {
        case e: IOException => e.printStackTrace 
      } finally {
        println("entered finally ...") 
        if (in.isDefined) in.get.close 
        if (out.isDefined) out.get.close 
      } 
      
      try {
        in = Some(new FileInputStream("/tmp/Test.class"))
        out = Some(new FileOutputStream("/tmp/Test.class.copy")) 
        in.foreach { inputStream => 
          out.foreach { outputStream =>
            var c = 0
            while ({c = inputStream.read; c != -1}) { 
              outputStream.write(c)
            } 
          } 
        }
      } 
      
      // 3.18. Creating Your Own Control Structures
      var k = 0
      import blah.utils.MyExtensionsObject._
      whilst(k < 5){
        k+=1
      }
      
    } 
    
    
    
    
  }   

  def basicArrays() = {
    //print an array
    for (i <- Array(1,2,3)) print(" " + i) 
    println
    // generator
    for (i <- Array(1,2,3)) yield i * 2 
    // filter the items, then double them
    List(1,2,3,4,5).filter(_ < 4).map(_ * 2).foreach { x => print("%i ", x) }
  }
}