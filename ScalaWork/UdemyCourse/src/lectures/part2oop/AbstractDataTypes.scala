package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract (contain unimplemented fields or methods)
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  //traits, can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded {

  }

  //basically means Crocodile inherits members from both Animal and Carnivore
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //Traits vs Abstract Classes
  //Both can have unimplemented and implemented members
  //1. traits can have constructor parameters
  //2. You can inherit multiple traits but only one abstract class
  //3. Traits are behavior, while abstract classes are a type of thing..
}
