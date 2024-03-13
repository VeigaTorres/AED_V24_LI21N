package week2Sorting

/**
 * Verify if the subarray contains the value.
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 * @return true if the value is in the array, false otherwise
 */
/*
  * Complexity in terms of time:
 *  worst case - O(n)
 *  best case - O(1)
 */
fun search(a: Array<Int>, value: Int,
           left: Int=0, right: Int=a.size-1): Boolean {
    for (i in left .. right)
        if (a[i] == value) return true
    return false
}

/**
 * Verify if the subarray contains the value. Recursive version
 * Methodology - If the value not is the first to the left, search
 *    in the right subarray.
 * Depth of the recursion: n
 * Complexity:
 *  in terms of time - O(n)
 *  in terms of extra space - O(n)
 * Recurrence: C(0) = O(1); C(n) = O(1) + C(n-1)
 */
tailrec fun searchTailRecursive(array: Array<Int>, value: Int,
                    left: Int=0, right: Int = array.size-1): Boolean
    = if (left > right) false                                       //O(1)
      else if(array[left] == value) true                            //O(1)
      else searchTailRecursive(array, value, left+1, right)     //C(n-1)



/**
 * Verify if the subarray contains the value. Recursive version
 * Methodology - If the value is not the middle value and if not exist
 *      in the first half of the subarray, search in the second half
 *      of the subarray.
 * Depth of the recursion: lg N
 * Complexity:
 *  in terms of time - O(N)
 *  in terms of extra space - O(lg N)
 *  Recurrence: C(0) = O(1); C(n) = O(1) + 2 x C(n/2)
 */
fun searchRecursive(array: Array<Int>, value: Int,
                    left: Int=0, right: Int = array.size-1): Boolean {
    if( left > right) return false                               // O(1)
    val m = (left + right) ushr 1  // left + (right-left)/2
    if ( array[m] == value ) return true
    return searchRecursive( array, value, left, m-1) ||     // C(n/2)
           searchRecursive( array, value, m+1, right)        // C(n/2)
}

/**
 * Verify if the sorted subarray contains the value. Recursive version
 * Methodology - If the value is not the middle value, search the value in
 *     first half of the subarray OR in the second half of the subarray depending
 *     on the value is less or greater than the middle value.
 * Depth of the recursion: lg n
 * Complexity:
 *  in terms of time - O(lg n)
 *  in terms of extra space - O(lg n)
 *  Recurrence: C(0) = O(1); C(n) = O(1) + C(n/2)
 */
tailrec fun searchBinaryRecursive(sortedArray: Array<Int>, value: Int,
                                  left: Int=0, right: Int=sortedArray.size-1): Boolean {
    if( left > right) return false                              //O(1)
    val m = (left + right) ushr 1  //left + (right-left) / 2
    if ( sortedArray[m] == value ) return true
    return if (sortedArray[m] > value )
              searchBinaryRecursive( sortedArray, value, left, m-1)     //C(n/2)
           else                                                              // ou
              searchBinaryRecursive( sortedArray, value, m+1, right)     //C(n/2)
}

/**
 * Verify if the sorted subarray contains the value. Iterative version.
 * Complexity:
 *  in terms of time - O(lg n)
 *  in terms of extra space - O(1)
 */
fun searchBinary(sortedArray: Array<Int>, value: Int,
                 left: Int=0, right: Int=sortedArray.size-1): Boolean {
    var l= left
    var r = right
    while ( l <=  r ) {
        val m = (l+r) ushr 1
        if ( value == sortedArray[m]) return true
        if ( value < sortedArray[m])
            r= m-1
        else
            l = m+1
    }
    return false

}

/**
 * Return the index to the first value, in the sorted subarray, wich has
 * a value not less than value (equal or greater than value).
 * Complexity:
 *  in terms of time -O(lg n)
 *  in terms of extra space - O(1)
 */
fun lowerBound(sortedArray: Array<Int>,value: Int, left: Int=0, right: Int=sortedArray.size-1): Int {
    var l= left
    var r = right
    while ( l <=  r ) {
        val m = (l+r) ushr 1
        if ( value <= sortedArray[m])
            r= m-1
        else
            l = m+1
    }
    return l
}

/**
* Return the index to the first value, in the sorted subarray, that is greater than value.
* Complexity:
*  in terms of time -
*  in terms of extra space -
*/
fun upperBound(sortedArray: Array<Int>, value: Int, left: Int, right: Int): Int = TODO()