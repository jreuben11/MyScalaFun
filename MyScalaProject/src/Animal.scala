import System.out.{println => p}

abstract class Animal { 
  def speak 
} 

trait WaggingTail {
  def startTail { p("tail started") } 
  def stopTail { p("tail stopped") } 
} 

trait FourLeggedAnimal { 
  def walk 
  def run 
} 

// 8.1. Using a Trait as an Interface
class Dog2 extends Animal with WaggingTail with FourLeggedAnimal { 
  def speak = p("Dog says 'woof'") 
  def walk { p("Dog is walking") } 
  def run { p("Dog is running") } 
} 