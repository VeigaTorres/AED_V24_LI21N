package week7ADT.stack

/**
 * Implementation of a stack data type using a linked list.
 * In a stack, the last element added is the first to be removed.
 * The elements are added and removed from the head of the list.
 * The insertion and deletion operations are O(1).
 * @param E the type of the elements in the stack
 */
class LinkedStack<E>() {
    private class Node<E>(val key: E, var next: Node<E>?)

    private var head: Node<E>? = null

}
