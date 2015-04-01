// 8.5. Limiting Which Classes Can Use a Trait by Inheritance 
class StarfleetComponent 
trait StarfleetWarpCore extends StarfleetComponent
class Starship extends StarfleetComponent with StarfleetWarpCore
class RomulanStuff
// won't compile:
//class Warbird extends RomulanStuff with StarfleetWarpCore

// 8.6. Marking Traits So They Can Only Be Used by Subclasses of a Certain Type 
trait StarfleetWarpCore2 {this: Starship2 =>}
class Starship2
class Enterprise extends Starship2 with StarfleetWarpCore2
// won't compile:
// class Warbird extends RomulanStuff with StarfleetWarpCore2

// 8.7. Ensuring a Trait Can Only Be Added to a Type That Has a Specific Method 
trait WarpCore {
  this: { def ejectWarpCore(password: String): Boolean } => 
} 
class Enterprise2 extends Starship with WarpCore { 
  def ejectWarpCore(password: String): Boolean = { true } 
} 

// 8.8. Adding a Trait to an Object Instance
class DavidBanner
trait Angry { 
  println("You won't like me ...")
}
class gamma {
  def blah = {
    val hulk = new DavidBanner with Angry  // mixin
  }
}
