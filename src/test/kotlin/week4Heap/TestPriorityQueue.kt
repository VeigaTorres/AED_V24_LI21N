package week4Heap

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestPriorityQueue {
    @Test
    fun testEmpty() {
        val pq = PriorityQueue<Int>(10, Int::compareTo)
        assertTrue( pq.isEmpty())
        assertEquals(0, pq.size())
    }

    @Test
    fun testOne() {
        val pq = PriorityQueue<Int>(10, Int::compareTo)
        assertTrue( pq.offer( 100 ) )
        assertFalse( pq.isEmpty())
        assertEquals(1, pq.size())
        assertEquals(100, pq.peek())
    }

    private fun <T> testOffer(pq: PriorityQueue<T>, v:T, expectValue: T, expectSize: Int) {
        assertTrue(pq.offer(v))
        assertFalse(pq.isEmpty())
        assertEquals(expectSize, pq.size())
        assertEquals(expectValue, pq.peek())
    }

    @Test
    fun testTwoDerescent() {
        var pq = PriorityQueue<Int>(2, Int::compareTo)
        testOffer(pq, 100, 100, 1)
        testOffer(pq, 10, 100, 2)
    }

    @Test
    fun testTwoCrescent() {
        var pq = PriorityQueue<Int>(2, Int::compareTo)
        testOffer(pq, 100, 100, 1)
        testOffer(pq, 500, 500, 2)
    }

    @Test
    fun testNotOffer() {
        var pq = PriorityQueue<Int>(2, Int::compareTo)
        testOffer(pq, 100, 100, 1)
        testOffer(pq, 10, 100, 2)

        assertFalse( pq.offer(200) )
        assertEquals(2, pq.size())
    }

    @Test
    fun testOfferNotIncreasingValue() {
        val values:Array<Int> = arrayOf(1000, 30, 200, 5)
        val pq = PriorityQueue<Int>(5, Int::compareTo)
        for ( v in values ) {
            assertTrue( pq.offer(v) )
            assertEquals(1000, pq.peek())
        }
        assertFalse( pq.isEmpty())
        assertEquals(values.size, pq.size())

        for( v in values.sortedArrayDescending())
            assertEquals(v, pq.poll())
    }

    @Test
    fun testOfferAlwaysIncreasing() {
        val values:Array<Int> = arrayOf(5, 30, 200, 1000)
        val pq = PriorityQueue<Int>(5, Int::compareTo)
        for ( v in values ) {
            assertTrue(pq.offer(v))
            assertEquals(v, pq.peek())
        }
        assertFalse( pq.isEmpty())
        assertEquals(1000, pq.peek())
        assertEquals(values.size, pq.size())

        for( v in values.sortedArrayDescending())
            assertEquals(v, pq.poll())
    }

    @Test
    fun testMinHeap() {
        val values:Array<Int> = arrayOf(1000, 30, 200, 5)
        val pq = PriorityQueue<Int>(10){
                a, b -> b.compareTo( a )
        }
        for ( v in values )
            pq.offer( v )
        assertFalse( pq.isEmpty())
        assertEquals(5, pq.peek())
        assertEquals(values.size, pq.size())

        for( v in values.sortedArray() )
            assertEquals(v, pq.poll())
    }

    @Test
    fun testArrayCrescent() {
        val values:Array<Int> = Array(10) { it+1 }
        val pq = PriorityQueue<Int>(10, Int::compareTo)
        for ( v in values )
            pq.offer( v )
        for( v in values.size downTo  1)
            assertEquals(v, pq.poll())
    }

    @Test
    fun testMinHeapStrings() {
        val values:Array<String> = arrayOf("1000", "5", "30","200" )
        val expected:Array<String> = arrayOf( "5", "30","200", "1000")
        val pq = PriorityQueue<String>(10){
                s1, s2-> s2.length - s1.length}
        for ( v in values )
            pq.offer( v )
        assertFalse( pq.isEmpty())
        assertEquals(values.size, pq.size())

        for( v in expected)
            assertEquals(v, pq.poll())
    }
}