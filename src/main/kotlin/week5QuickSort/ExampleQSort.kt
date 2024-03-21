package week5QuickSort

import kotlin.random.Random
import week1Examples.algorithmEvaluation
data class Algorithm(val description: String, val algorithm: (Array<Int>, Int, Int, (Int, Int)->Int)-> Unit)
internal val sorts = arrayOf<Algorithm>(
   Algorithm("initial", ::quickSort0)
   , Algorithm("semi iterative on right", ::quickSort1)
   , Algorithm("semi iterative (right or left depending on the dimension)", ::quickSort)
   , Algorithm("uses the median of 3 for the pivot",::quickSortWithMedian)
//   , Algorithm("hibrido usando 3 partições",::quickSortHybrid )
)

private val N: Int = 10000


data class ArrayType(val name: String, val initFunction: (Int) -> Int)
private val arrayTypes = arrayOf<ArrayType>(
    ArrayType("only with zeros (all equals)", { 0 }),
    ArrayType("sorted", { i -> i }),
    ArrayType("reversed sort", { i -> N - i }),
    ArrayType("random", { i -> Random.nextInt(N) })
)

fun main(args: Array<String>) {
    var arrayTest :Array<Int>
    for (typeOfArray in arrayTypes) {
        System.out.println("*** array ${typeOfArray.name}")
        var index =0
        for (sort in sorts)
            try {
                System.out.println("\t** sorted by: algorithm ${sort.description}")
                val a = Array<Int>(N, typeOfArray.initFunction)
                val elapsedTime= algorithmEvaluation(){
                    sort.algorithm(a, 0, a.size-1, Int::compareTo)}
                testSorted(a, elapsedTime)
                println()
            }
            catch (e: Throwable) {
                println("\t-> ${e.toString()} ")
            }
            finally { ++index }
    }
}

private fun testSorted(array: Array<Int>, time: Long) {
    for (i in 1 until  array.size)
        if (array[i] < array[i - 1]) {
            print("\t -> NOT SORTED")
            return
        }
    print("\t -> SORTED [$time ms]")
}


