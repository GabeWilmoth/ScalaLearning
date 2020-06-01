package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))
  //println(factorial(5000))

  //THE ABOVE FUNCTION RUNS INTO A STACK OVERFLOW ERROR AS THE STACK CAN NO LONGER HOLD THE RECURSIVE INFORMATION
  //AFTER A CERTAIN AMOUNT OF RECURSIVE CALLS

  def anotherFactorial(n: Int): BigInt = {
    @tailrec //Will throw an error is the function is not tail recursive!
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use a recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
  = 2 * 3 * 4 * ... * 10 * 1
   */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION!

  /*
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  // 1.
  @tailrec
  def concatString(name: String, n: Int, accumulator: String) : String = {
    if (n <= 0) accumulator
    else concatString(name, n - 1, accumulator + name)
  }

  println(concatString("Hello", 5, ""))

  //2.
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  //3.
  def fibonacci(n: Int): Int = {
    @tailrec
    def sequence(i: Int, prev: Int, prevPrev: Int): Int = {
      if(i >= n) prev
      else sequence(i + 1, prev + prevPrev, prev)
    }
    if(n <= 2) 1
    else sequence(2, 1, 1)
  }
  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
