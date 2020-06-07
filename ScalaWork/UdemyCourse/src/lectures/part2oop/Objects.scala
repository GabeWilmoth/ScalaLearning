package lectures.part2oop

object Objects extends App {

  //Scala doesn't have class level functionality ("Static")
  //Instead we have objects which can have a static like functionality
  //Objects can be defined in a similar way as classes, except with the fact that objects can't take parameters
  object Person { //type + its only instance....
    val N_EYES = 2 //This is how Scala defines class level functionality (or static functionality)
    def canFly: Boolean = false

    //Factory method, as its sole purpose is to build Persons given parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    //instance-level functionality
  }

  //The process of having class and object of the same name in the same scope is called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala objects are SINGLETON INSTANCE(type + its only instance...)
  val mary = Person
  val john = Person
  println(mary == john) //True because "mary" and "john" point to the same instance...

  val matt = new Person("Matt")
  val sabrina = new Person("Sabrina")
  println(matt == sabrina) //You can instanciate new instances of Person with class Person but not object Person

  val bobbie = Person(matt, sabrina)
  //SAME AS ABOVE, BUT SINCE APPLY() IS SPECIAL WE CAN WRITE IT LIKE ABOVE... val bobbie = Person.apply(matt, sabrina)

  //Scala Applications, only a Scala object with def main(args: Array[String]): Unit
}
