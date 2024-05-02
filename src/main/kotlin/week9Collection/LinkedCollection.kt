package week9Collection

/**
 * Dinamic data structure that represents a collection of elements
 * stored in a doubly linked list with sentinel node.
 * This class is a simplified version of the LinkedList class in Java.
 * @param E the type of the elements in the collection
 */
class LinkedCollection<E> : MutableCollection<E> {
    private class Node<E> (val value: E = Any() as E){
        var prev: Node<E> = this
        var next: Node<E> = this
    }

    //<< Instance variables >>
    private var count: Int = 0    // Number of elements contained.
    private val head: Node<E> = Node() // sentinel node

    override val size get() = count
    override fun isEmpty(): Boolean = count == 0
    override fun clear() {
        head.next = head
        head.prev = head
        count = 0
    }

    /**
     * Add functions
     */
    private fun makeNode(suc: Node<E>, e:E): Node<E> {
        val n = Node<E>(e)
        linkNode(n, suc)
        return n
    }
    private fun linkNode(n: Node<E>, suc: Node<E> ){
        val prev = suc.prev
        n.next = suc
        n.prev = prev
        prev.next = n
        suc.prev = n
    }
    private fun addNode(suc: Node<E>, e: E): Node<E> {
        ++count
        return makeNode(suc, e)
    }
    fun addFirst(e: E) {
        addNode(head.next, e)
    }
    fun addLast(e: E)  {
        addNode( head, e)
    }
    override fun add(element: E): Boolean {
        addLast( element )
        return true
    }
    override fun addAll(elements: Collection<E>): Boolean {
       elements.forEach { add(it) }
       return elements.isNotEmpty()
    }

    /**
     * Remove functions
     */
    private fun unlinkNode(n: Node<E>) {
        n.prev.next = n.next
        n.next.prev = n.prev
    }
    private fun removeNode(n: Node<E>): Node<E> {
        --count
        unlinkNode(n)
        return n
    }
    override fun remove(element: E): Boolean {
        val n = getNode( element )
        if ( n == null ) return false
        removeNode( n )
        return true
    }

    fun removeFirst(): E {
        check(!isEmpty())
        return removeNode(head.next).value
    }
    fun removeLast(): E {
        check(isNotEmpty())
        return removeNode( head.prev).value
    }

    fun removeIf( pred: (e: E)-> Boolean): Boolean {
        var curr = head.next
        var removed = false
        while ( curr != head ) {
            if (pred( curr.value )) {
                val n = curr
                curr= curr.next
                removeNode(n)
                removed= true
            }
            else curr= curr.next
        }
        return removed
    }
    override fun removeAll(elements: Collection<E>): Boolean
            = removeIf{ elements.contains(it) }
    override fun retainAll(elements: Collection<E>): Boolean
            = removeIf { !elements.contains(it) }

    /**
     * Search functions
     */
    private fun getNode(e: E): Node<E>? {
        var n = head.next
        while ( n != head) {
            if (n.value == e) return n
            n = n.next
        }
        return null
    }
    override fun contains(element: E) = getNode(element) != null
    override fun containsAll(elements: Collection<E>): Boolean =
        elements.all{ contains( it ) }

    fun getFirst() : E {
        check( isNotEmpty() )
        return head.next.value
    }

    fun getLast() : E {
        check( isNotEmpty() )
        return head.prev.value
    }
    /**
     * Iterator
     */
    override fun iterator(): MutableIterator<E> =
        object: MutableIterator<E> {
            var last = head
            var flagNext = false
            override fun hasNext(): Boolean = last.next!=head
            override fun next(): E {
                if (!hasNext()) throw NoSuchElementException()
                flagNext = true
                last = last.next
                return last.value
            }
            override fun remove() {
                check( flagNext ){"can’t remove"}
                removeNode(last)
                last = last.prev
                flagNext= false
            }
        }

    /**
     * Merge lists
     */
    private fun move(p: Node<E>, first:Node<E>, last:Node<E>) {
        last.prev.next = p
        first.prev.next = last
        p.prev.next = first
        val prev = p.prev
        p.prev = last.prev
        last.prev = first.prev
        first.prev = prev
    }
    fun merge( lst: LinkedCollection<E>,
               cmp: Comparator<E> ) {
        require( lst !== this ){"the lists cannot be the same"}
        var first1 = head.next; val last1 = head
        var first2 = lst.head.next; val last2= lst.head
        while (first1 !== last1 && first2 !== last2) {
            if (cmp.compare(first1.value, first2.value) <= 0)
                first1= first1.next
            else {
                do { first2= first2.next
                } while ( first2!=last2 &&
                          cmp.compare(first2.value, first2.value)<0)
                move(first1, lst.head.next, first2)
            }
        }
        if (first2 !== last2)
            move(first1, first2, last2)
        count += lst.size
        lst.count = 0
    }

}