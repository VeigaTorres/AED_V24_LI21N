package week7ADT.lists

class DoubleLinkedSentinel<E> {
    private class Node<E> ( val key: E = Any() as E )  {
            var next = this
            var prev = this
    }

    private var sentinel= Node<E>()

    private fun listInsert( x: Node<E> ) {
        TODO()
    }

    private fun listDelete( x: Node<E>) {
        TODO()
    }

    private fun listSearch( k: E ) : Node<E> {
        var x : Node<E> = sentinel.next
        while ( x != sentinel && x.key != k)
            x= x.next
        return x
    }

    fun add( k: E) {
        TODO()
    }
    fun remove( k: E ) {
        TODO()
    }
    fun contains( k: E ) : Boolean{
        TODO()
    }

}