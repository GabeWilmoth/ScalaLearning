package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //EXPRESSION, evaluated to a value and have a type, in this case Int
  println(x)

  println(2 + 3 * 4) //Mul is done first, then addition.

  //Instructions (DO) vs Expressions (VALUE, every bit of your code will compute a value)
  //IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // This IF EXPRESSION evaluates to a value
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  //There are loops in scala but the use of them is discouraged as they don't evaluate to a value

  //SCALA FORCES EVERYTHING TO BE AN EXPRESSION!
  var aVariable = 2
  val aWeirdValue = (aVariable = 3) //Unit type for aWeirdValue UNIT === void
  println(aWeirdValue) //prints out a Unit or ()

  //Side effects: println(), whiles, reassigning...

  //Code Blocks, special type of expression, value of the block is the value of its last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)
  //val anotherValue = z + 1 DOESNT WORK AS z IS SCOPED TO THE CODEBLOCK
}
