package week2Sorting

/**
 * Verify if the subarray contains the value.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 * @return true if the value is in the array, false otherwise
 */
fun search(a: Array<Int>, value: Int,
           left: Int=0, right: Int=a.size-1): Boolean = TODO()

/**
 * Verify if the subarray contains the value. Recursive version
 * Methodology - If the value not is the first to the left, search
 *    in the right subarray.
 * Depth of the recursion:
 * Complexity:
 *  in terms of time -
 *  in terms of extra space -
 */
fun searchTailRecursive(array: Array<Int>, value: Int,
                    left: Int=0, right: Int = array.size-1): Boolean = TODO()


/**
 * Verify if the subarray contains the value. Recursive version
 * Methodology - If the value is not the middle value and if not exist
 *      in the first half of the subarray, search in the second half
 *      of the subarray.
 * Depth of the recursion:
 * Complexity:
 *  in terms of time -
 *  in terms of extra space -
 */
fun searchRecursive(array: Array<Int>, value: Int,
                    left: Int=0, right: Int = array.size-1): Boolean = TODO()

/**
 * Verify if the sorted subarray contains the value. Recursive version
 * Methodology - If the value is not the middle value, search the value in
 * first half of the subarray OR in the second half of the subarray depending
 * on the value is less or greater than the middle value.
 * Depth of the recursion:
 * Complexity:
 *  in terms of time -
 *  in terms of extra space -
 */
fun searchBinaryRecursive(sortedArray: Array<Int>, value: Int,
                          left: Int=0, right: Int=sortedArray.size-1): Boolean = TODO()

/**
 * Verify if the sorted subarray contains the value. Iterative version.
 * Complexity:
 *  in terms of time -
 *  in terms of extra space -
 */
fun searchBinary(sortedArray: Array<Int>, value: Int,
                 left: Int=0, right: Int=sortedArray.size-1): Boolean = TODO()

/**
 * Return the index to the first value, in the sorted subarray, wich has
 * a value not less than value (equal or greater than value).
 * Complexity:
 *  in terms of time -
 *  in terms of extra space -
 */
fun lowerBound(sortedArray: Array<Int>,value: Int, left: Int=0, right: Int=sortedArray.size-1): Int = TODO()

/**
* Return the index to the first value, in the sorted subarray, that is greater than value.
* Complexity:
*  in terms of time -
*  in terms of extra space -
*/
fun upperBound(sortedArray: Array<Int>, value: Int, left: Int, right: Int): Int = TODO()