package week7ADT.stack

/**
 * Implementation of a stack data type using a linked list.
 * In a stack, the last element added is the first to be removed.
 * The elements are added and removed from the head of the list.
 * The insertion and deletion operations are O(1).
 * @param E the type of the elements in the stack
 */
class LinkedStack<E>() : Stack<E> {
    private class Node<E>(val key: E, var next: Node<E>?)

    private var head: Node<E>? = null
    var count = 0
    override val size: Int
        get()  = count
        /*{ // O(n)
            var count = 0;
            var curr = head
            while (curr != null ) {
                ++count
                curr = curr.next
            }
            return count
        }*/

    override fun isEmpty(): Boolean = head == null
    override fun peek(): E {
        return checkNotNull( head ){"stack is empty"}.key
    }

    override fun iterator(): Iterator<E> {
         class Iter : Iterator<E> {
            var curr: Node<E>? = head
            override fun hasNext(): Boolean = curr != null

            override fun next(): E {
                return (curr?:throw NoSuchElementException("no more elements")).let{
                    curr= it.next
                    it
                }.key
            }

        }
        return Iter()
    }

    override fun pop(): E { // remove the first node
        val first = checkNotNull(head){"stack empty"}
        val second = first.next
        head = second
        --count
        return first.key
    }
    override fun push(e: E) { // Add the element in start
        val oldFirst = head
        val first = Node(e, oldFirst)
        head = first
        ++count
    }

}

fun main() {
    val a = LinkedStack<Int> ()
    for (  i in  0 .. 3)
        a.push(i)
    for ( v in a)
        println( v )
}