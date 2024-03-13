package week4Heap

/*
 * The PriorityQueue is a data structure that allows to insert elements and
 * extract the element with the highest priority.
 * In a priority queue, we typically have the following operations:
 *  Insertion (offer): Add an element to the queue along with its priority.
 *  Deletion (poll) : Remove and return the element with the highest priority.
 *  Peek (peek): View the element with the highest priority without removing it.
 *  Size (size): Get the number of elements currently in the priority queue.
 *  Empty (isEmpty): Verify if the priority queue is empty.
 * The implementation of a priority queue using a maxheap.
 */
class PriorityQueue<T> (capacity:Int, val comparator:(T, T)-> Int)  {
    private val heap:Array<T> = arrayOfNulls<Any>(capacity) as Array<T>
    private var heapSize= 0
    fun size():Int  = TODO()
    
    fun isEmpty(): Boolean = TODO()

    fun peek(): T { // Complexity:
        check( !isEmpty() ){"illegal operation (peek): empty heap"}
        TODO()
    }
    fun poll( ): T { // Complexity:
        check( !isEmpty() ){"illegal operation (poll): empty heap"}
        TODO()
    }
    fun offer( v: T):Boolean { // Complexity:
        TODO()
    }
}