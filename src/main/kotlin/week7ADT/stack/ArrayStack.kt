package week7ADT.stack

/**
 * Implementation of a stack data type using an array.
 * In a stack, the last element added is the first to be removed.
 * The elements are added and removed from the top of the array.
 * The insertion and deletion operations are O(1).
 * @property capacity the maximum number of elements in the stack
 * @param E the type of the elements in the stack
 */
class ArrayStack<E>(val capacity: Int)  {
    private val array: Array<E> = arrayOfNulls<Any>(capacity) as Array<E>
    private var top: Int = 0


}
