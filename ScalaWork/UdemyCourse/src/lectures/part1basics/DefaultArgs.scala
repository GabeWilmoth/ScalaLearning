package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  def anotherFactorial(n: Int): BigInt = {
    @tailrec //Will throw an error is the function is not tail recursive!
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use a recursive call as the LAST expression

    factHelper(n, 1)
  }

  //IN THE ABOVE FUNCTION WE SET THE ACCUMULATOR TO A VALUE OF 1 FOR EVERY CALL OF ANOTHERFACTORIAL...
  //INSTEAD WE CAN CLEAN IT UP AND JUST SET A DEFAULT VALUE FOR THE ACCUMULATOR....
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  val fact10 = trFact(10)
  //or the default value can be overwritten
  val fact10Two = trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  //savePicture(800) doesn't know which var you are referring to
  savePicture(width = 800) //does know which you are referring to
  savePicture(height = 200, format = "png", width = 900) //can refer to vars out of order this way.
}
