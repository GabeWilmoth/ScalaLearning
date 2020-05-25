package lectures.part1basics

object Functions extends App {
  //Def to declare a function, standard parameters, return type as String and the
  // implementation of said function will concatinate a and b
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)


  //WHEN YOU NEED LOOPS, USER RECURSION!!!
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + " " + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))

  //Normally want functions that have side effects and return Unit when logging, printing to a file, etc...
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
    1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2.  Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4.  Tests if a number is prime.
   */

  //1
  def aGreeting(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old."
  println(aGreeting("Bobby", 21))

  //2
  def aFactorial(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorial(n-1)
  }
  println(aFactorial(4))

  //3
  def aFibonacci(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacci(n - 1) + aFibonacci(n - 2)
  }
  println(aFibonacci(8))

  //4
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
