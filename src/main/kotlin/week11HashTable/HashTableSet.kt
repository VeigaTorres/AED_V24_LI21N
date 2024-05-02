package week11HashTable

class HashTableSet<K> ( capacityInitial:Int=5,
                        val loadFactor: Float= 0.75f): MutableSet<K> {
    private class Node<K> (  val key: K,
                             var next: Node<K>?,
                             val hc: Int )
    private var table: Array< Node<K>? > = arrayOfNulls(capacityInitial)
    private var count = 0
    private var threshold =  (capacityInitial * loadFactor).toInt()

    val capacity: Int get() = table.size
    override val size: Int get() = count
    override fun clear() {
        table.fill( null )
        count = 0
    }

    override fun containsAll(elements: Collection<K>): Boolean =
         elements.all{ contains( it )}


    override fun addAll(elements: Collection<K>): Boolean {
        val oldSize = size
        elements.forEach{  add(it) }
        return size != oldSize
    }

    override fun isEmpty(): Boolean = size==0

    private fun hash( hc: Int ): Int = hc.and( 0x7fff_ffff ) % capacity

    private fun getNode( key: K ): Node<K>? {
        val hc = key.hashCode()
        val index =hash( hc )
        var curr = table[index]
        while( curr != null ) {
            if (hc == curr.hc && curr.key == key) return curr
            curr= curr.next
        }
        return null
    }

    override fun contains(element: K): Boolean = getNode(element) != null

    override fun add(element: K) : Boolean {
        if (contains(element)) return false
        val hc = element.hashCode()
        val index = hash( hc )
        val first = table[index]
        val newFirst = Node<K>( element, first, hc)
        table[index] = newFirst
        ++count
        if( count > threshold  ) expand()
        return true
    }

    override fun remove(element:K) : Boolean { //O(1)
        val hc = element.hashCode()
        val index = hash( hc )
        var curr = table[index]
        var prev: Node<K>? = null
        while ( curr != null ) {
            if ( hc == curr.hc && curr.key == element ) {
                if ( prev == null ) table[index] = curr.next
                else prev.next= curr.next
                --count
                return true
            }
            prev = curr
            curr = curr.next
        }
        return false
    }

    private fun expand() {
       val oldTable = table
       table = arrayOfNulls(capacity * 2 )
       threshold = (capacity * loadFactor).toInt()
       for(i in oldTable.indices) {
           var curr = oldTable[i]
           while ( curr != null ) {
               val n = curr
               curr = curr.next
               val hc = n.hc //n.key.hashCode()
               val index = hash( hc )
               n.next = table[index]
               table[index]= n
           }
       }
     }

     override fun iterator() =
        object : MutableIterator<K> {
            var index = -1
            var curr: Node<K>? = null
            var prev: Node<K>? = null
            override fun hasNext(): Boolean {
                while ( curr == null && index+1 < capacity) {
                    ++index
                    curr = table[index]
                }
                return curr != null
            }

            override fun next(): K {
                if (hasNext()) {
                    curr?.let {
                        prev = curr
                        curr = it.next
                        return it.key
                    }
                }
                throw NoSuchElementException("No more element")
            }

            override fun remove() {
                val n = checkNotNull(prev){"not have next() before"}
                remove( n.key )
                prev = null
            }
        }

    override fun retainAll(elements: Collection<K>): Boolean
        = removeIf { !elements.contains( it ) }

    override fun removeAll(elements: Collection<K>): Boolean
        = removeIf { elements.contains(it) }
}
