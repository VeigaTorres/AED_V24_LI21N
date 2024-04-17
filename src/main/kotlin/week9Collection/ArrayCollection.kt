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
class ArrayCollection<E>( capacityInicial: Int = 10 ) {//:  RandomAccess, MutableCollection<E>{
    //<< Instance variables >>
    private var count = 0       // Number of elements contained.
    private var array: Array<E> = allocate( capacityInicial )// allocates memory to elements

    val capacity: Int get() = array.size
    val size: Int get() = count

    operator fun get(index: Int): E {
        require( index < count)
        TODO()
    }
    operator fun set(index: Int, element: E): E {
        require( index < count)
        TODO()
    }

    private fun allocate( n: Int ): Array<E> =
        arrayOfNulls<Any>( max(n, 1) ) as Array<E>

    fun add( i: Int, e: E) {
        require( i <= count )
        TODO()
        ++count
    }

    fun removeAt( index: Int ) {
        require(index in 0 ..< count )
        TODO()
        --count
    }

    fun indexOf( e: E ): Int {
        for ( i in 0 until count )
            if (array[i] == e) return i
        return -1
    }

    fun removeIf( pred: ( E)-> Boolean ): Boolean {
       var last= 0
       for( i in 0 ..< size)
           if( !pred(array[i]) ) array[last++]= array[i]
       count = last
       return false
    }

    operator fun iterator(): MutableIterator<E> =
        object : MutableIterator<E> {
            var index= 0
            override fun hasNext(): Boolean = index < count
            override fun next(): E {
                if(!hasNext())
                    throw NoSuchElementException("no more elements")
                return array[index++]

            }
            override fun remove() {
                TODO()
            }
        }
}