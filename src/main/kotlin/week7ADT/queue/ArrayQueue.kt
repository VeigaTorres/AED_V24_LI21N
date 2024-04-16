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
class ArrayQueue<E>(val capacity: Int) : Queue<E>, Iterable<E> {
    private val array = arrayOfNulls<Any>(capacity) as Array<E>
    private var head: Int = 0
    private var tail: Int = 0
    private var count = 0
    override val size: Int
        get() = count

    override fun isEmpty(): Boolean = count == 0

    override fun peek(): E {
        if (isEmpty()) throw NoSuchElementException("not exist element")
        return array[head]
    }

    override fun poll(): E {
        check(!isEmpty()) { "queue is empty" }
        //if ( isEmpty() ) throw IllegalStateException("queue is empty")
        val x = array[head]
        head = (head + 1) % array.size
        --count
        return x
    }

    override fun offer(e: E): Boolean {
        if (size == capacity) return false
        array[tail] = e
        tail = (tail + 1) % array.size
        ++count
        return true
    }



    override fun iterator(): Iterator<E> {
        class Iter<E> : Iterator<E> {
            var index=0
            override fun hasNext(): Boolean {
                return index < count
            }
            override fun next(): E {
                TODO("Not yet implemented")
            }
        }
        return Iter()
    }


}

fun main() {
    val a= ArrayQueue<Int>(5)
    for( v in a ) println(v)
}

