package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def +(newPersonNickname: String): Person = new Person(s"$name ($newPersonNickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(learn : String): String = s"$name learns $learn"
    def learnsScala =  this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent to the above
  // infix notation = operator notation  (ONLY WORKS WITH METHODS WITH ONE PARAMETER) (syntactic sugar)

  //"operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS!

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation (functions that don't receive any parameters)
  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply()) //APPLY IS SPECIAL IN SCALA
  println(mary()) //equivalent (Here we are looking for the function definition for apply)

  /*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"
    2.  Add an age to the Person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
    3.  Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnsScala method, calls learns method with "Scala".
        Use it in postfix notation.
    4.  Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the Rockstar").apply())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))
}
