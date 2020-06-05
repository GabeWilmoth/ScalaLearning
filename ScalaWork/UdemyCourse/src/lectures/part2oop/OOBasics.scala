package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)

  person.greet("Gabe")
  person.greet()

  //Testing practice
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//Constructor
class Person (name: String, val age: Int){
  //The class parameter 'age' is not a member of the class person, thus you can't reference it via the '.'(dot) notation...
  //however, you can make it a member by adding the 'val' or 'var' keyword before it name

  val x: Int = 2

  println(1 + 3)
  //When a class is instanciated every expression within said class will be evaluated... Thus the println displays in
  //the console, before the value of age...

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0) //uses the parent constructor to create this constructor...
  def this() = this("John Doe") //uses the constructor above to create this constructor...
  //WOULD JUST BE EASIER TO SUPPLY A DEFAULT OF 0 AS THE AGE IN THE CLASS DEFINITION...
  //SO class Person (name: String, val age: Int = 0)
}

/*
  Novel and a Writer
  Writer: first name, surname, year
    - method fullname, returns concat of first and surname
  Novel: name, year of release, author(instance of type writer)
  - authorAge, age of author at year of release
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName(): String = firstName + " " + lastName
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge(): Int = releaseYear - author.year

  //This refers to the class level data not the method level data...
  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
  Counter class
    - receives an int value
    - method current count, returns the currentCount
    - method to increment/decrement => new Counter (inc and dec counter by 1, but return a new Counter)
    - overload inc/dec to receive an amount
 */

class Counter(val value: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(value + 1)  // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(value - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(value)
}
