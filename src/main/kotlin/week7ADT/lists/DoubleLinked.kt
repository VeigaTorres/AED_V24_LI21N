package week7ADT.lists

class DoubleLinked<E> { //: Iterable<E> {
    private class Node<E> (val key:E) {
        var next: Node<E>? = null
        var prev: Node<E>? = null
    }

    private var head: Node<E>? = null

    private fun listInsert( x: Node<E>) {
        TODO()
    }

    private fun listDelete( x: Node<E> ) {
        TODO()
    }

    private fun listSearch( k: E ) : Node<E>? {
        TODO()
    }

    fun add( k: E) {
        TODO()
    }
    fun remove( k: E ) {
        TODO()
    }
    fun contains( k: E ): Boolean {
        TODO()
    }
}