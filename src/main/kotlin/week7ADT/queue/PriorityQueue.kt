package week7ADT.queue

import week4Heap.extractMaxHeap
import week4Heap.heapIncreaseKey
import kotlin.Comparator

/*
 * The PriorityQueue is a data structure that allows to insert elements and
 * extract the element with the highest priority.
 * In a priority queue, we typically have the following operations:
 *  Insertion (offer): Add an element to the queue along with its priority.
 *  Deletion (poll) : Remove and return the element with the highest priority.
 *  Peek (peek): View the element with the highest priority without removing it.
 *  Size (size): Get the number of elements currently in the priority queue.
 *  Empty (isEmpty): Verify if the priority queue is empty.
 * The implementation of a priority queue using a MINHEAP,
 * the parent is always SMALLER than its children.
 */
class PriorityQueue<E> (val capacity: Int, val comparator: Comparator<E>) : Queue <E> {
    // In a minheap, the parent is always smaller than its children
    // the compare function is used to compare the elements in the maxheap
    // must be inverted to create a minheap.
    private val compare: (E,E)->Int = { a, b-> comparator.compare(b, a)}

    private val heap: Array<E> = arrayOfNulls<Any>(capacity) as Array<E>
    private var sizeHeap: Int = 0
    override val size: Int
        get() = sizeHeap

    override fun isEmpty(): Boolean = size == 0

    override fun peek(): E {
        if( isEmpty()) throw  NoSuchElementException("")
        return heap[0]
    }

    override fun offer(e: E): Boolean {
        if (sizeHeap == heap.size) return false
        //heap[sizeHeap] = e
        heapIncreaseKey(heap, sizeHeap, e, compare)
        ++ sizeHeap
        return true
    }

    override fun poll(): E {
        check( !isEmpty() ){""}

     /*   val e = heap[0]
        heap[0] = heap[sizeHeap-1]
        maxHeapify(heap, sizeHeap-1, 0, compare)
        --sizeHeap
        return e

      */
        return extractMaxHeap(heap, sizeHeap--, compare)
    }

    override fun iterator(): Iterator<E> =
        object : Iterator<E> {
            var index = 0
            override fun hasNext(): Boolean = index < sizeHeap
            override fun next(): E {
                if( !hasNext() ) throw NoSuchElementException("no more elements")
                return heap[index++]
            }

        }
}