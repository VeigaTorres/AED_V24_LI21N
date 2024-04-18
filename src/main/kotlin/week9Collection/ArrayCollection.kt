package week9Collection

import kotlin.math.max

/**
 * Dinamic data structure that represents a collection of elements
 * stored in an array. The dimensions of the array are increased
 * automatically when the array is full. The array is increased
 * by a factor of 2.
 * This class is a simplified version of the ArrayList class.
 * @param E the type of the elements in the collection
 * @param capacityInicial Initial capacity of the collection.
 */
class ArrayCollection<E>( capacityInicial: Int = 10 ) : MutableCollection<E>{
    //<< Instance variables >>
    private var count = 0       // Number of elements contained.
    private var array: Array<E> = allocate( capacityInicial )// allocates memory to elements

    private fun allocate( n: Int ): Array<E> =
        arrayOfNulls<Any>( max(n, 1) ) as Array<E>
    val capacity: Int get() = array.size
    override val size: Int get() = count
    override fun isEmpty(): Boolean = count== 0

    operator fun get(index: Int): E {
        require( index < count)
        return array[index]
    }

    operator fun set(index: Int, element: E): E {
        require( index < count)
        val old= array[index]
        array[index ]= element
        return old
    }

    override fun clear() {
        count =0
    }

    fun add( i: Int, e: E) {
        require( i <= count )
        if ( size == capacity) {
            val aux = array
            array = allocate( size*2)
            aux.copyInto( array, 0, 0, i)
            aux.copyInto(array, i+1, i, size)
        }
        else
            array.copyInto(array, i+1, i, size)

        array[i]= e
        ++count
    }

    override fun add(element: E): Boolean {
        add(count, element)
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean {
        elements.forEach {add( it )}
        return !elements.isEmpty()
    }

    fun indexOf( e: E ): Int {
        for ( i in 0 until count )
            if (array[i] == e) return i
        return -1
    }

    override fun contains(element: E): Boolean =
        indexOf( element ) !=-1

    override fun containsAll(elements: Collection<E>): Boolean =
        elements.all { indexOf(it) != -1 }

    fun removeAt( index: Int ) {
        require(index in 0 ..< count )
        array.copyInto(array, index, index+1, size)
        --count
    }

    fun removeIf( pred: ( E)-> Boolean ): Boolean {
       var flag = false
       var last= 0
       for( i in 0 ..< size)
            if ( ! pred( array[i] ) ) array[last++]= array[i]
            else flag = true
       count = last // Na aula faltava atualizar o count
       return flag
    }

    override fun remove(element: E): Boolean {
        val ind = indexOf( element)
        if ( ind == -1 ) return false
        removeAt(ind)
        return true
    }

    override fun retainAll(elements: Collection<E>): Boolean =
        removeIf { !elements.contains(it) }

    override fun removeAll(elements: Collection<E>): Boolean =
        removeIf { elements.contains( it ) }

    override operator fun iterator(): MutableIterator<E> =
        object : MutableIterator<E> {
            var index= 0
            override fun hasNext(): Boolean = index < count
            override fun next(): E {
                if(!hasNext())
                    throw NoSuchElementException("no more elements")
                return array[index++]
            }
            override fun remove() {
                removeAt(index-1)
                --index
            }
        }

}