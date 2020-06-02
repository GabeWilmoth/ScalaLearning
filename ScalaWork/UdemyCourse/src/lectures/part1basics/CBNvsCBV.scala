package lectures.part1basics

object CBNvsCBV extends App {

  //Here System.nanoTime() is computed before the function is called and that result is passed in as X
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // => tells the compiler that the parameter will be called by name
  //Here System.nanoTime() is computed when x is used....
  def calledByName(x: => Long): Unit = {
    println("by name: " + x) //System.nanoTime() is computed here
    println("by name: " + x) //System.nanoTime() is then computed again here
  }
  //Thus we have two different values in the println of the calledByName Function

  calledByValue(System.nanoTime()) //current time of system in nanoseconds
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //println(infinite(), 34) WILL THROW A STACK OVERFLOW AS infinite() IS AN INFINITE LOOP
  //println(34, infinite()) WILL NOT THROW A STACK OVERFLOW AS infinite() IS NEVER CALLED AS THE var y IS NEVER USED..
  //REMEMBER => EXPRESSION IS ONLY EVALUATED WHEN THE VARIABLE IS USED.
}
