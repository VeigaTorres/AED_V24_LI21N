package week7ADT.stack

/**
 * Implementation of a stack data type using an array.
 * In a stack, the last element added is the first to be removed.
 * The elements are added and removed from the top of the array.
 * The insertion and deletion operations are O(1).
 * @property capacity the maximum number of elements in the stack
 * @param E the type of the elements in the stack
 */
class ArrayStack<E>(val capacity: Int) : Stack<E> {
    private val array: Array<E> = arrayOfNulls<Any>(capacity) as Array<E>
    private var top: Int = 0     // index of next push

    override val size: Int get() = top
    override fun isEmpty(): Boolean = top == 0

    override fun push(e: E)  {
        check(top < capacity){ "underflow"}
        array[top]= e   // array[top++]= e
        top++
    }

    override fun pop(): E {
        check( !isEmpty() ) { "stack is empty"}
        top--
        return  array[top]   // return array[--top]
    }

    override fun peek(): E {
        check(!isEmpty()) { "stack is empty"}
        return array[top-1]
    }

    private inner class IterArray : Iterator<E> {
        var index = size
        override fun hasNext(): Boolean = index > 0
        override fun next(): E {
            if ( !hasNext() ) throw NoSuchElementException("No more elements")
            --index
            val v = array[index]
            return v
        }

    }
    override fun iterator(): Iterator<E> = IterArray()
}

fun main() {
    val a = ArrayStack<Int> (8)
    for (  i in  0 .. 3)
        a.push(i)
    for ( v in a)
        println( v )
}
