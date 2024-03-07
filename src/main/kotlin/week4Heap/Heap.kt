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
 * C(1) =
 * C(N) =
 * Complexity:
 * @param heap   - heap represented in array
 * @param heapSize - number of nodes in the heap
 * @param i - index of the root node of the heap
 */
fun <T>  maxHeapify(heap: Array<T>, heapSize: Int, i: Int,
                            compare: (T, T)-> Int) {
    TODO()
}

/**
 * Make a minimum heap with root in the node i, according to a given comparator.
 * The left and right subtrees of i are minimum heaps.
 * Complexity:
 * @param heap   - heap represented in array
 * @param heapSize - number of nodes in the heap
 * @param i - index of the root node of the heap
 */
fun <T> minHeapify(heap: Array<T>, heapSize: Int, i: Int,
                   compare: (T, T)-> Int) {

    maxHeapify(heap, heapSize,i ){
            a, b -> compare( b, a)
    }
}

/**
 * Make a maximum heap in the first n nodes of the array.
 * first n nodes of the array
 * Complexity:
 * @param a array with the values to organize.
 * @param n number of nodes in the heap
 */
fun <T> buildMaxHeap(a: Array<T>, n: Int=a.size,
                     compare:(T, T)->Int) {
    TODO()
}

/**
 * Make a minimum heap in the first n nodes of the array.
 */
fun <T> buildMinHeap(a: Array<T>, n: Int=a.size, compare:(T, T)->Int) {
    TODO()
}

/**
 * Sort an array using the heap sort algorithm.
 * C(1) =
 * C(n) =
 * Complexity:
 *  best case - O(n)
 *  worst case - O(n lg n)
 *  in terms of extra space - O(1)
 * @param a array to be sorted
 */
fun <T> heapSort(a: Array<T>, compare:(T, T)->Int) {
    TODO()
}

/**
 * Replace the value of a node i in a heap represented in array, by a new value.
 * The new value is greater than the old value, according to a given comparator.
 * Complexity:
 * @param heap heap represented in array
 * @param i index of the node whose value will be changed to a greater one
 * @param value new value
 */
fun <T> heapIncreaseKey(heap: Array<T>, i: Int, value: T, compare: (T, T) -> Int) {
    TODO()
}

/**
 * Remove the maximum value from a heap represented in array.
 * The maximum value is the root of the heap and it is in the
 * position 0 of the array.
 * Complexity:
 * @param heap array representado em array
 * @param heapSize numero de n�s do array
 * @return o valor retirado
 */
fun <T> extractMaxHeap(heap: Array<T>, heapSize: Int, compare: (T, T) -> Int): T {
    TODO()
}
