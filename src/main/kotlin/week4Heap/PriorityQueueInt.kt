package week4Heap

/*
 * The PriorityQueue is a data structure that allows to insert elements and
 * extract the element with the highest priority.
 * In a priority queue, we typically have the following operations:
 *      Insertion (offer): Add an element to the queue along with its priority.
 *      Deletion (poll) : Remove and return the element with the highest priority.
 *      Peek (peek): View the element with the highest priority without removing it.
 *      Size (size): Get the number of elements currently in the priority queue.
 *      Empty (isEmpty): Verify if the priority queue is empty.
 * The implementation of a priority queue using a maxheap.
 */
@Suppress("UNCHECKED_CAST")
class PriorityQueueInt (val capacity:Int, val comparator:(Int, Int)-> Int)  {
    private val heap:Array<Int> = arrayOfNulls<Any>(capacity) as Array<Int>
    private var heapSize= 0
    fun size():Int  = heapSize
    fun isEmpty(): Boolean = size() == 0
    fun peek(): Int { // Complexity:
        check( !isEmpty() ){"illegal operation (peek): empty queue"}
        return heap[0]
    }
    fun poll( ): Int { // Complexity:
        check( !isEmpty() ){"illegal operation (poll): empty heap"}
        val max = extractMaxHeap(heap, heapSize,comparator)
        --heapSize
        return max
    }
    fun offer( v: Int):Boolean { // Complexity:
        if ( heapSize == capacity ) return false
        heap[heapSize] = v
        heapIncreaseKey(heap, heapSize, v, comparator)
        ++heapSize
        return true
    }
}
