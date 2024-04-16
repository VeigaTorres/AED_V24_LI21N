package week7ADT.stack

/**
 * Interface for a stack data type.
 * In a stack, the last element added is the first
 * to be removed (LIFO).Have the following operation:
 *     Push: Add an element to the stack.
 *     Pop: Remove and return the last element added.
 *     Peek: View the last element added to the stack
 *           without removing it.
 *     IsEmpty: Verify if the stack is empty.
 * @property size the number of elements in the stack
 * @param E the type of the elements in the stack
 */
interface Stack<E> : Iterable<E> {
    val size: Int
    fun isEmpty(): Boolean
    fun push(e: E)
    fun pop(): E
    fun peek(): E
}
