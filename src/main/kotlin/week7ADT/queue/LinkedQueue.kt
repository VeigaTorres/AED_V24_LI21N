package week7ADT.queue

/**
 * It is a generic class that implements the Queue interface.
 * LinkedQueue is a queue implementation using a linked list.
 * @param E the type of the elements in the queue
 * @property head the first node in the queue
 * @property tail the last node in the queue
 * @property count the number of elements in the queue
 * @constructor creates an empty queue
 */
class LinkedQueue<E>  {
    private class Node<T> (val key: T, var next: Node<T>? = null)

    private var head: Node<E>? = null
    private var tail: Node<E>? = null
    private var count = 0

}
