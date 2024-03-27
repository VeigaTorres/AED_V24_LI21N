package week5QuickSort
import week2Sorting.*

fun <T> partition( a: Array<T>, l: Int=0, r: Int=a.size-1, compare:(T,T)->Int ) =
    partitionHoare(a, l, r, compare)
/**
 * -- First version of quick sort.
 * Divide an array into two parts based on a pivot element.
 * The elements of the array a such that all elements less than or
 * equal to a chosen pivot element are placed before it, and all
 * elements greater than the pivot are placed after it.
 * The partition function returns the index q of the pivot element
 * after partitioning.
 * @param a array to sort
 * @param l index from which the sort is made (inclusive)
 * @param r index until which the sort is made (inclusive)
 * @param compare function to compare two elements of the array
 *
 * Depth of the recursion:
 */
fun <T> quickSort0(a: Array<T>, l: Int=0, r: Int=a.size-1, compare:(T,T)->Int) {
    if ( r <= l ) return
    // Divide the array into two parts
    val q = partition(a, l, r, compare)
    // Sort recursively the two sub-arrays
    quickSort0( a, l, q-1, compare)
    quickSort0(a, q+1, r, compare)
}

/**
 * Using the LOMUTO algorithm for partitioning. Divide an array
 * into two parts based on a pivot element.
 * The index q is the position of the pivot element after
 * partitioning:
 *      a[l .. q-1] <= a[q]
 *      a[q+1 .. r] >  a[q]
 * +----------------------------------------------------------+
 * |  pivot <=           | pivot |     > pivot                |
 * +----------------------------------------------------------+
 *                        ^q
 * @param a array to partition
 * @param l index from which the partition is made (inclusive)
 * @param r index until which the partition is made (inclusive)
 * @return i
 */
fun <T> partitionLomuto(a: Array<T>, l: Int, r: Int,
                        compare:(T,T)->Int) : Int {
    /*
     * +-----------------------------------------------------------+
     * |   pivot <=          |    > pivot     |      ?     | pivot |
     * +-----------------------------------------------------------+
     * ^l                  ^i                  ^j              ^r
     * 	Invariant of the cycle
     * 	  a[l .. i] <= pivot
     *    a[i+1 .. j-1] > pivot
     *    a[j .. r-1] in analysis
     */
    var i =l-1
    val pivot = a[r]
    for ( j in l until r) {
        if ( compare( a[j], pivot) < 0) {
            ++i
            a.exchange(i,j)
        }
    }
    a.exchange(i+1, r)
    return i+1

}

/**
 * QuickSort - Version semi-iterative
 * Divide an array into two parts based on a pivot element,
 * sort first sub-arrays recursively and the second sub-array
 * iteratively.
 * Depth of the recursion:
 */
fun <T>quickSort1(a: Array<T>, left: Int=0, right: Int=a.size-1, compare: (T, T) -> Int) {
    var r = right
    var l = left
    while (r > l) {
        // Divide the array into two parts
        val q = partition(a, l, r, compare)
        // Sort recursively only the left sub-arrays
        quickSort1(a, l, q - 1, compare)
        // quickSort1(a, q + 1, r, compare)
        l = q+1
    }
}

/**
 * QuickSort - final version
 * Divide an array into two parts based on a pivot element,
 * and sort the smaller sub-array recursively and the larger
 * sub-array iteratively.
 * Depth of the recursion:
 */
fun <T> quickSort(a: Array<T>, left: Int=0, right: Int=a.size-1,
                  compare: (T, T) -> Int) {
    var r = right
    var l = left
    while (r > l) {
        // Divide the array into two parts
        val q = partition(a, l, r, compare)
        // Sort recursively only the smaller sub-arrays
        if ( q-l > r- q ) {
            quickSort(a, q+1, r, compare)
            r = q-1
        }
        else {
            quickSort(a, l, q - 1, compare)
            l = q+1
        }
    }
}


/**
 * Compare the three values: a[l], a[r], a[(r+l)/2]
 * The largest value was placed in a[r], the smallest in a[l]
 * and the midean in a[r-1]
 */
private fun <T> median(a: Array<T>, l: Int, r: Int, compare: (T, T) -> Int) {
    a.exchange( r-1, (l+r) ushr 1)
    if(compare(a[l], a[r-1] )> 0) a.exchange( l, r-1)
    if(compare(a[l], a[r]) > 0) a.exchange(l, r)
    if(compare(a[r-1], a[r]) >0) a.exchange(r, r-1)
}

/**
 * QuickSort that uses the median of three to choose the pivot
 * Compare the three values: a[left], a[right], a[(right+left)/2]
 * The largest value was placed in a[right], the smallest in a[left]
 * and the midean in a[right-1]
 * @param a array to sort
 * @param left index from which the sort is made (inclusive)
 * @param right index until which the sort is made (inclusive)
 */
fun <T> quickSortWithMedian(a: Array<T>, left: Int=0, right: Int=a.size-1,
                            compare: (T, T) -> Int) {
    var r = right
    var l = left
    while (r > l) {
        // Choose the pivot using the median of three
        median(a, l, r, compare)
        // Divide the array into two parts
        if ( (r-l) <= 2) return
        val q = partition(a, l+1, r-1, compare)
        // Sort recursively the smaller sub-arrays
        if ( q-l > r- q ) {
            quickSortWithMedian(a, q+1, r, compare)
            r = q-1
        }
        else {
            quickSortWithMedian(a, l, q - 1, compare)
            l = q+1
        }
    }}

/**
 * Using the Hoare algorithm for partition.Divide an array
 * into two parts based on a pivot element.
 * The index q is the position of the pivot element after
 * partition:
 *      a[l .. q-1] <= a[q]
 *      a[q+1 .. r] >  a[q]
 * +----------------------------------------------------------+
 * |  pivot <=           | pivot |     > pivot                |
 * +----------------------------------------------------------+
 *                        ^q */
fun <T> partitionHoare(a: Array<T>, l: Int=0, r: Int=a.size-1, compare: (T, T)-> Int): Int {
    /* +----------------------------------------------------------+
     * |   pivot <         |        ?      |  >= pivot      |pivot|
     * +----------------------------------------------------------+
     *                      ^i            ^j                  ^r
     * 	Invariant of the cycle
     * 	  a[l .. i-1]   < pivot
     *    a[j+1 .. r-1] >= pivot
     *    a[i .. j]     in analysis
     */
    val pivot = a[r]
    var i = l
    var j = r - 1
    while (i <= j) {
        while (compare(a[i], pivot) < 0) ++i
        while (j >= i && compare(a[j], pivot) > 0) --j
        if (i <= j) a.exchange( i++, j--)
    }
    a.exchange(i, r)// Coloca o pivot entre os menores  e os maiores ou iguais
    return i
}

/**
 * Divide the array into three parts. Being q0 and q1 the indices of the partitions:
 *  a[l .. q0]    < pivot
 *  a[q0+1 .. q1-1]   == pivot
 *  a[q1 .. r]  > pivot
 * +----------------------------------------------------------+
 * |  pivot <           |     == pivot     |     > pivot      |
 * +----------------------------------------------------------+
 *                    ^q0                   ^q1
 * @param a array to partition
 * @param left index from which the partition is made (inclusive)
 * @param right index until which the partition is made (inclusive)
 * @return  Pair(q0, q1), q0 is the index of the last element smaller
 *                        than the pivot and q1 is the index of the
 *                        first element greater than the pivot.
 */
@Suppress("ControlFlowWithEmptyBody")
fun <T> threePartition(a: Array<T>, left: Int=0, right: Int=a.size-1, compare: (T, T)->Int): Pair<Int, Int> {
    /*
     * First divide the array into four parts.
     * +----------------------------------------------------------+
     * | == pivot |  pivot <  |    ?      |  > pivot   | == pivot |
     * +----------------------------------------------------------+
     *            ^p          ^i          ^j           ^q
    */
    val pivot = a[right]
    var p = left - 1; var i = left - 1
    var j = right; var q = right
    /* Invariant of the cycle
     * 	a[l .. p]       == pivot
     * 	a[p+1 .. i]     <  pivot
     *  a[j-1 .. q]     > pivot
     *	a[q .. r]       == pivot
     */
    while (true) {
        while (compare(a[++i], pivot) <0);
        while (compare(pivot, a[--j])<0 && j != i);
        if (i >= j) break
        a.exchange(i, j)
        if (compare(a[i], pivot) == 0) a.exchange(i, ++p)
        if (compare(a[j], pivot) == 0) a.exchange(j, --q)
    }
    /* The array is divided into four parts.
     * +----------------------------------------------------------+
     * | == pivot |  pivot <         |       > pivot   | == pivot |
     * +----------------------------------------------------------+
     *           ^p                  ^i                ^q
     * p is the index of the last element equal in the left part
     * i is the index of the first element larger than the pivot
     * q is the index of the first element equals in the right part
     */

    /*Put the equals in the center of the array*/
    var q0 = i - 1
    var q1 = i
    for(k in left .. p) a.exchange(k, q0--)
    for( k in right downTo q) a.exchange(k, q1++)
    /* The array is divided into three parts.
     * +----------------------------------------------------------+
     * |  pivot <          |      == pivot       |       > pivot  |
     * +----------------------------------------------------------+
     *                   ^q0                     ^q1
     * q0 is the index of the last element smaller than the pivot
     * q1 is the index of the first element greater than the pivot
     */
    return Pair(q0, q1)
}

/**
 * Algorithm quick sort using the midean of three and three partitions
 * +----------------------------------------------------------+
 * |   pivot <         |        equal pivot      |  >= pivot  |
 * +----------------------------------------------------------+
 *                     ^q0                     ^q1             ^r
 */
fun <T> quickSortThreePartition(a: Array<T>, left: Int=0, right: Int=a.size-1,
                                compare: (T, T)-> Int) {
    var l = left
    var r = right
    while (l < r) {
        // Get the median of three
        median(a, l, r, compare)
        if (r - l <= 2) return
        // Divide the array into three parts
        val (q0, q1) = threePartition(a, l + 1, r - 1, compare)
        // Sort recursively the left or right sub-array depending
        // on the smallest size
        if (q0 - l < r - q1) {
            quickSortThreePartition(a, l, q0, compare)
            l = q1
        } else {
            quickSortThreePartition(a, q1, r, compare)
            r = q0
        }
    }
}

/**
 * QuickSort hybrid.
 * Sorting using a hybrid algorithm, insertion sort for small arrays,
 * and quick sort with median of three and three partitions for
 * larger arrays.
 * @param a array to sort
 * @param left index from which the sort is made (inclusive)
 * @param right index until which the sort is made (inclusive)
 */
fun <T> quickSortHybrid(a: Array<T>, left: Int=0, right: Int=a.size-1, compare: (T,T)-> Int) {
    var l = left
    var r = right
    while (l < r) {
        // For small arrays, use insertion sort
        if (r - l < 15) {
           insertionSort(a, l, r, compare)
           return
        }
        // Choose the pivot using the median of three
        median(a, l, r, compare)
        // Divide the array into three parts
        val (q0, q1) = threePartition(a, l + 1, r - 1, compare)
        // Sort recursively the left or right sub-array depending on the smallest size
        if (q0 - l < r - q1) {
            quickSortHybrid(a, l, q0, compare)
            l = q1
        } else {
            quickSortHybrid(a, q1, r, compare)
            r = q0
        }
    }
}

