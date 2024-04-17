package week7ADT.lists

class DoubleLinkedSentinel<E> : Iterable<E> {
    private class Node<E> ( val key: E = Any() as E )  {
            var next = this
            var prev = this
    }

    private var sentinel= Node<E>()

    private fun listInsert( x: Node<E> ) {
        val seg = sentinel.next
        x.next = seg
        x.prev = sentinel
        seg.prev = x
        sentinel.next = x
    }

    private fun listDelete( x: Node<E>) {
       x.prev.next = x.next // val ant = x.prev; ant.next = x.next
       x.next.prev = x.prev
    }

    private fun listSearch( k: E ) : Node<E> {
        var curr: Node<E> = sentinel.next
        while ( curr != sentinel ) {
            if ( curr.key == k ) return curr
            curr = curr.next
        }
        return curr
    }

    fun add( k: E) {
       listInsert( Node(k) )
    }

    fun remove( k: E ) {
        val n = listSearch( k )
        if ( n != sentinel) listDelete( n)
    }

    fun contains( k: E ) : Boolean{
        return listSearch( k ) != sentinel
    }

    override fun iterator(): Iterator<E> =
        object : Iterator<E> {
            var curr = sentinel
            override fun hasNext(): Boolean = curr.next != sentinel

            override fun next(): E {
                if (!hasNext())throw NoSuchElementException("")
                curr = curr.next
                return curr.key
            }
        }

}

fun main() {
    val a =DoubleLinkedSentinel<Int> ()
    for (  i in  0 ..< 5)
        a.add(i)
    for ( v in a)
        println( v )
    println("....")
    a.remove( 4 )          // remove the first
    a.remove(2)            // remove the second element
    a.remove(0)            // remove the last element
    for ( v in a)
        println( v )

}