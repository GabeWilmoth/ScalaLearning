package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)
  //VALS ARE IMMUTABLE, not really constants more intermediate computation holders.

  var aVariable: Int = 4
  aVariable = 5 //Side effect, allow us to change and see changes in code.
  //VARS CAN BE REASSIGNED (MUTABLE)
}
