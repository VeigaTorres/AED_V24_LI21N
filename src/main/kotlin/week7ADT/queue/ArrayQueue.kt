package week7ADT.queue

/**
 * ArrayQueue is a queue implementation using an array
 * @param E the type of the elements in the queue
 * @property capacity the maximum number of elements in the queue
 * @property array the array to store the elements
 * @property count the number of elements in the queue
 * @property head the index of the first element in the queue
 * @property tail the index of the next available position in the queue
 * @constructor creates an empty queue with the given capacity
 */
class ArrayQueue<E>(val capacity: Int)  {
    private val array = arrayOfNulls<Any> (capacity) as Array<E>
    private var head: Int = 0
    private var tail: Int = 0

}

