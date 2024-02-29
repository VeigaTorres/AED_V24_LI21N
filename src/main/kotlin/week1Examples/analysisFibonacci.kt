package week1Examples

import week1Examples.fibonacci
import week1Examples.fibonacciMemoryN
import week1Examples.fibonacciRecursive

/**
 * Evaluate the time of the function.
 * 1. Print the identifier of the function;
 * 2. Foreach value in the array, call algorithmEvaluation to
 *    obtain the time of the function and print the value and
 *    the time of the evaluation.
 * print the value and the time of the function.
 * @param values the values to be evaluated in the function
 * @param identifier the identifier of the function
 * @param funFibonacci the function to be evaluated
 */
fun evaluateFifonacci(identifier:String, values: Array<Int>, funFibonacci: (Int) -> Int) {
    println("----- $identifier -----")
    for ( v in values ) {
      print("$v ")
      val time = algorithmEvaluation() { funFibonacci(v) }
      println("$time")
    }
}

fun main() {
    evaluateFifonacci("fibonacci", getMultiples(5, 1920000), ::fibonacci)
    evaluateFifonacci("fibonacci with auxiliar memory", getMultiples(4, 1920000), ::fibonacciMemoryN)
    evaluateFifonacci("fibonacci recursive", getMultiples(3, 20),::fibonacciRecursive)
}
