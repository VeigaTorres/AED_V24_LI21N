package week7ADT.lists

class DoubleLinked<E> : Iterable<E> {
    private class Node<E> ( val key: E ) {
        var next: Node<E>? = null
        var prev: Node<E>? = null
    }

    private var head: Node<E>? = null

    private fun listInsert( x: Node<E>) {
        x.next = head
        x.prev = null
        head?.prev = x
        head = x
    }

    private fun listDelete( x: Node<E> ) {
        if ( x.prev == null ) head = x.next
        else x.prev?.next = x.next
        x.next?.prev = x.prev
    }

    private fun listSearch( k: E ) : Node<E>? {
        var curr = head
        while ( curr != null ) {
            if ( curr.key == k ) return curr
            curr = curr.next
        }
        return null // TODO: implement i
    }

    fun add( k: E) {
        listInsert( Node(k) )
    }
    fun remove( k: E ) {
        val x = listSearch( k )
        if ( x != null) listDelete( x )
    }
    fun contains( k: E ): Boolean {
        return listSearch( k ) != null
    }

    override fun iterator(): Iterator<E> {
        return object : Iterator<E> {
            private var curr = head
            override fun hasNext(): Boolean = curr != null
            override fun next(): E {
                val n = curr
                if (n == null)  throw NoSuchElementException("stack empty")
                curr = n.next
                return n.key
            }
        }
    }
}