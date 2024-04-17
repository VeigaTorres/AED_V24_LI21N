package week7ADT.lists

import week7ADT.queue.LinkedQueue

class DoubleLinked<E> : Iterable<E> {
    private class Node<E> ( val key: E ) {
        var next: Node<E>? = null
        var prev: Node<E>? = null
    }

    private var head: Node<E>? = null

    private fun listInsert( x: Node<E> ) {
        x.next = head
        x.prev = null
        val first = head
        if ( first != null ) {
            first.prev = x
        }
        head = x
    }

    private fun listDelete( x: Node<E> ) {
        val seg = x.next
        if ( seg != null)
            seg.prev = x.prev
        val ant = x.prev
        if ( ant != null )
            ant.next = x.next
        else
            head = x.next
    }

    private fun listSearch( k: E ) : Node<E>? {
        var curr = head
        while ( curr != null ) {
            if (curr.key == k) return curr
            curr= curr.next
        }
        return null
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


fun main() {
    val a =DoubleLinked<Int> ()
    for (  i in  0 ..< 5)
        a.add(i)
    for ( v in a)
        println( v )
    println("....")
    a.remove( 4 )          // remove the first
    a.remove(2)            // remove the second element
    a.remove(0)            // remove the last element
    for ( v in a)  println( v )

}