package week6LinearSort

import kotlin.math.ceil
import kotlin.math.log
import kotlin.math.pow

/**
 * Sort an array using the counting sort algorithm. The algorithm is stable.
 * @param a array with the elements to be sorted
 * @param b array with the sorted elements
 * @param n number of elements in the array to be sorted
 * @param k each element of the array a is an integer between 0..k
 */
private fun countingSort(a: Array<Int>, b: Array<Int>, n:Int, k: Int) {
    TODO()
}
/**
 * Sort an array using the counting sort algorithm. The algorithm is stable.
 * The maximum value in the array must be less than the length of the array.
 * @param a array com os elementos a serem ordenados
 */
fun countingSort( a: Array<Int> ) {
    TODO()
}

/**
 * The function sorts the  array a based on the digits at the
 * specified digitNumber. It uses counting sort to accomplish this,
 * where each digit is represented by rBits number of bits.
 * @param a array to be sorted.
 * @param b array where sorted elements will be placed.
 * @param digitNumber: Specifies which digit position to consider for sorting.
 * @param rBits: Number of bits used to represent each digit.
 */
private fun countingRadixSort( a: Array<Int>, b: Array<Int>,
                               digitNumber: Int, rBits: Int) {
    // Maximum value with rBits. It will be used as a mask for rBits
    val mask = (1 shl rBits) - 1 // == k == 2^rBits -1
    // Number of shifts knowing that each digit occupies rBits
    val shift = digitNumber * rBits
    val c = Array(mask + 1) {0}
    // Count occurrences of each digit at the specified digit position

    // Adjust the counts to indicate the position of each digit in the output array
    for( i in 1 until c.size)
        c[i] += c[i-1]

    // Place the elements in the output array

}

/**
 * Sorts the array using the Radix Sort algorithm, leveraging CountingRadixSort
 * for sorting individual digit positions.
 * @param v array de inteiros positivos
 */
fun radixSort(v: Array<Int>) {
    if (v.size <= 1) return
    // Calculate the number of bits required to represent the array size
    val r_bits = 31 - v.size.countLeadingZeroBits()
    // Calculate the number of digits needed based on the number of bits per digit
    val d_digits = ceil(32.0 / r_bits).toInt()
    var a = v
    var b = Array(v.size) { 0 }
    // Iterate through each digit position
    //  1. Sort based on the current digit position using Counting Radix Sort
    //  2. Swap the arrays
}


