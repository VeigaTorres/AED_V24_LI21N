package week4Heap

import week2Sorting.exchange

/**
 * Get the index of the parent of any node in a heap represented in array
 * @param i index of the node
 * @return the index of the parent of the node i
 */
fun parent(i: Int): Int  = (i - 1) shr 1

/**
 * Get the index of the left descendant of any node in a heap represented in array
 * @param i index of the node
 * @return the index of the left descendant of the node i
 */
fun left(i: Int): Int = (i shl 1) + 1

/**
 * Get the index of the right descendant of any node in a heap represented in array
 * @param i index of the node
 * @return the index of the right descendant of the node i
 */
fun right(i: Int): Int = (i shl 1) + 2

/**
 * Make a maximum heap with root in the node i, according to a given comparator.
 * The left and right subtrees of i are maximum heaps.
 * C(1) = O(1)
 * C(N) =
 * Complexity:
 * @param heap   - heap represented in array
 * @param heapSize - number of nodes in the heap
 * @param i - index of the root node of the heap
 */
tailrec fun <T>  maxHeapify(heap: Array<T>, heapSize: Int, i: Int,
                            compare: (T, T)-> Int) {
    val l = left( i )
    val r = right( i )
    var largest = if (l < heapSize && compare(heap[l], heap[ i]) > 0 ) l else i
    if ( r < heapSize && compare(heap[r], heap[largest])> 0) largest = r
    if( largest != i ) {
        heap.exchange(largest, i)
        maxHeapify(heap, heapSize, largest, compare)
    }
}

/**
 * Make a minimum heap with root in the node i, according to a given comparator.
 * The left and right subtrees of i are minimum heaps.
 * Complexity: O(lg n)
 * @param heap   - heap represented in array
 * @param heapSize - number of nodes in the heap
 * @param i - index of the root node of the heap
 */
fun <T> minHeapify(heap: Array<T>, heapSize: Int, i: Int,
                   compare: (T, T)-> Int) {
    maxHeapify(heap, heapSize, i) { a, b-> compare(b, a) }
}

/**
 * Make a maximum heap in the first n nodes of the array.
 * first n nodes of the array
 * Complexity: O(n) =
 * @param a array with the values to organize.
 * @param n number of nodes in the heap
 */
fun <T> buildMaxHeap(a: Array<T>, n: Int=a.size,
                     compare:(T, T)->Int) {
    for( i in parent( n-1) downTo 0)
        maxHeapify(a, n, i, compare)
}

/**
 * Make a minimum heap in the first n nodes of the array.
 */
fun <T> buildMinHeap(a: Array<T>, n: Int=a.size, compare:(T, T)->Int) {
    TODO()
}

/**
 * Sort an array using the heap sort algorithm.
 * C(1) = O(1)
 * C(n) = O(n) + n x O(lg n) = O(n x (lg n+1)) = O(n lg n)
 * Complexity:
 *  best case - O(n)
 *  worst case - O(n lg n)
 *  in terms of extra space - O(1)
 * @param a array to be sorted
 */
fun <T> heapSort(a: Array<T>, compare:(T, T)->Int) {
    buildMaxHeap(a,a.size,compare)
    for( i in a.size-1 downTo 1) {
        a.exchange(0, i)
        maxHeapify(a, i, 0, compare)
    }
}

/**
 * Replace the value of a node i in a heap represented in array, by a new value.
 * The new value is greater than the old value, according to a given comparator.
 * C(1) = O(1)
 * C(n) = O(1) + C(n/2) = O(lg n)
 * Complexity:
 *  best case - O(1)
 *  worst case - O(lg n)
 *  in terms of extra space - O(lgn)
 * @param heap heap represented in array
 * @param i index of the node whose value will be changed to a greater one
 * @param value new value
 */
tailrec fun <T> heapIncreaseKey(heap: Array<T>, i: Int, value: T, compare: (T, T) -> Int) {
    heap[i ] = value
    val p = parent( i )
    if ( p >= 0  && compare( heap[i], heap[p])> 0) {
        heap.exchange(i, p)
        heapIncreaseKey(heap, p, value, compare)
    }
}

/**
 * Remove the maximum value from a heap represented in array.
 * The maximum value is the root of the heap and it is in the
 * position 0 of the array.
 * Complexity:
 * @param heap heap represented in array
 * @param heapSize number of nodes in the heap
 * @return value of the maximum element in the heap that was removed
 */
fun <T> extractMaxHeap(heap: Array<T>, heapSize: Int, compare: (T, T) -> Int): T {
    val max = heap[0]
    heap[0] = heap[heapSize-1]
    maxHeapify( heap, heapSize-1, 0, compare)
    return max
}
