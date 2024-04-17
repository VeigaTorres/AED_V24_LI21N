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
class LinkedQueue<E> :Queue<E> {
    private class Node<T> (val key: T, var next: Node<T>? = null)

    private var head: Node<E>? = null
    private var tail: Node<E>? = null
    private var count = 0

    override val size: Int
        get() = count

    override fun isEmpty(): Boolean = head == null

    override fun peek(): E {
        val first = head?: throw NoSuchElementException("not exist elements")
        return first.key
    }

    override fun poll(): E {
        val first = checkNotNull(head) {"queue is empty"}
        head = first.next
        --count
        return first.key
    }

    override fun offer(e: E): Boolean {
        val newNode = Node<E>(e )
        if( head == null ) {
            head= newNode
            tail = newNode
        }
        else {
           tail?.next = newNode
           tail = newNode
        }
        ++count
        return true
    }

    override fun iterator(): Iterator<E> {
        return object: Iterator<E> {
            var curr = head
            override fun hasNext(): Boolean {
                return curr != null
            }

            override fun next(): E =
                (curr?: throw NoSuchElementException("no more elements") ).also {
                    curr= it.next
                }.key
        }
    }

}

fun main() {
    val a = LinkedQueue<Int> ()
    for (  i in  0 ..< 4)
        a.offer(i)
    for ( v in a)
        println( v )
    println("....")
    a.poll()            // remove the first element
    a.offer(4)        // add a new element
    for ( v in a)
        println( v )

}
