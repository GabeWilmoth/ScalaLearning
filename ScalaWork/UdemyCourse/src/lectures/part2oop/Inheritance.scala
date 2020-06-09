package lectures.part2oop

object Inheritance extends App {

  //single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  //Subclass only inherit non-private members of a Superclass
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) {

  }

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"
    override def eat = {
      super.eat //will refer to method eat in super class
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //Type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat //method call will go to most overridden version whenever possible

  //super

  //preventing overrides
  // 1 - use final on member
  // 2 - use final on class
  // 3 - seal the class (softer restriction in which you can extend classes in this file, but prevents it in other files)
  // - often used when you want to be exhaustive in your type hierarchy
}
