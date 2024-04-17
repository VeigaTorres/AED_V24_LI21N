package week7ADT.queue

/**
 * Interface for a queue data type.
 * In a queue, the first element added is the first
 * to be removed (FIFO). Have the following operation:
 *     Offer: Add an element to the queue.
 *     Poll: Remove and return the first element added.
 *     Peek: View the first element added to the queue
 *           without removing it.
 *     IsEmpty: Verify if the queue is empty.
 * @property size the number of elements in the queue
 * @param E the type of the elements in the queue
 */
interface Queue<E>: Iterable<E>  {
    val size: Int
    fun isEmpty(): Boolean
    fun peek(): E
    fun offer(e: E): Boolean
    fun poll() : E
}
