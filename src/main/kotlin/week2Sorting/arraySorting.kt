package week2Sorting
fun Array<Int>.exchange(i1: Int, i2: Int) {
    val aux = this[i1]
    this[i1] = this[i2]
    this[i2] = aux
}

/**
 * Sort an subarray using the insertion sort algorithm. The algorithm is stable.
 * Methodology - in initial iteration, the first element is considered as sorted, and
 *      the remaning elements are considered as unsorted part.
 *      Fo each iteration take one value at a time from the unsorted part of the array
 *      and insert it in the correct position in the sorted part of the array.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun insertionSort(a:Array<Int>, left:Int=0, right: Int=a.size-1) {
    TODO()
}

/*
fun insertionSort(a:Array<Int>, left:Int=0, right: Int=a.size-1,
                  compare: (Int,Int)-> Int) { TODO() }
fun sortCrescent( a: Array<Int> ) { TODO() }
fun sortDeCrescent( a: Array<Int>) { TODO() }
*/

/**
 * Sort an subarray using the bubble sort algorithm. The algorithm is stable.
 * Methodology - for each iteration, transverse the array from the end to the
 *      beginning, compares the current element with the previous one, and if
 *      the current element is smaller, it exchanges the two elements.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun bubbleSort(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    TODO()
}

/**
 * Sort an subarray using the bubble sort algorithm optimized with a flag.
 * Methodology - When it detects that it is already sorted (not exist exchanges
 *               in the last iteration) it ends the sorting.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun bubbleSortFlag(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    TODO()
}

/**
 * Sort an subarray using the selection sort algorithm. The algorithm not is stable.
 * Methodology - for each iteration SELECT the smallest
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun selectionSort(a:Array<Int>, left: Int=0, right: Int=a.size-1) {
    TODO()
}

/**
 * Sort an subarray using the merge sort algorithm. The algorithm is stable.
 * Methodology - Divide and conquer algorithm.
 *   It divides the array in two halves, sorts the two halves and
 *   then merges the two sorted halves.
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun mergeSort(a:Array<Int>, left: Int=0, right: Int = a.size-1 )  {
    TODO()
}
/**
 * Take two sorted subarrays and merge them into a single sorted subarray.
 * First subarray is a[left .. m] and the second subarray is a[m+1..right]
 * Complexity in terms of time:
 *  worst case -
 *  best case -
 * @param a - array
 * @param left - index where the subarray starts (inclusive)
 * @param m - index where the first subarray ends (inclusive)
 * @param right - index where the subarray ends (inclusive)
 */
fun merge(a: Array<Int>, left: Int, m: Int, right: Int) {
    TODO()
}