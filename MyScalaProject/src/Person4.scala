// 4.6. Overriding Default Accessors and Mutators
class Person4(private var _name: String) {
  def name = _name // accessor 
  def name_=(aName: String) { _name = aName } // mutator 
} 