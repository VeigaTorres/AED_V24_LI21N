package week11HashTable

class HashTableSet<K> ( capacityInitial:Int=5,
                        val loadFactor: Float= 0.75f) {//: MutableSet<K> {
    private class Node<K> (  val key: K,
                             var next: Node<K>?,
                             val hc: Int )
    private var table: Array< Node<K>? > = arrayOfNulls(capacityInitial)
    private var count = 0
    private var threshold =  (capacityInitial * loadFactor).toInt()

    val capacity: Int get() = table.size
    val size: Int get() = count

    private fun hash( hc: Int ): Int = hc.and( 0x7fff_ffff ) % capacity

    private fun getNode( key: K ): Node<K>? {
        val hc = key.hashCode()
        val index =hash( hc )
        var curr = table[index]
        while( curr != null ) {
            if (curr.key == key) return curr
            curr= curr.next
        }
        return null
    }

    fun contains(element: K): Boolean = getNode(element) != null

    fun add(element: K) : Boolean {
        TODO()
        ++count
        if( count > threshold  ) expand()
        return true
    }

    fun remove(element:K) : Boolean { //O(1)
        TODO()
     }

    private fun expand() {
       val oldTable = table
       table = arrayOfNulls(capacity * 2 )
       threshold = (capacity * loadFactor).toInt()
       TODO()
     }

    fun iterator() =
        object : MutableIterator<K> {

            override fun hasNext(): Boolean {
                TODO()
            }

            override fun next(): K {
                TODO()
            }

            override fun remove() {
                TODO()
            }

        }

}
