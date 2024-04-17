package week7ADT.lists

import kotlin.test.*

class TestLinkedLists {
    //private fun emptyCollection():DoubleLinked<Int> = DoubleLinked<Int>()
    private fun emptyCollection():DoubleLinkedSentinel<Int> = DoubleLinkedSentinel<Int>()

    @Test
    fun test_emptyCollection() {
        val c = emptyCollection()
        assertFalse(c.iterator().hasNext())
    }

    @Test
    fun test_emptyIterator() {
        val it: Iterator<Int> = emptyCollection().iterator()
        assertFalse(it.hasNext())
    }

    @Test
    fun test_singleton() {
        val c = emptyCollection()
        c.add(2)
        val it = c.iterator()
        assertTrue(it.hasNext())
        assertEquals(2, it.next())
        assertFalse(it.hasNext())
    }

    @Test
    fun test_add() {
        val c= emptyCollection()
        for (i in 1 .. 5 )
            c.add(i)
        val it = c.iterator()
        for (i in 5 downTo  1 ) {
            assertTrue(it.hasNext())
            assertEquals(i, it.next())
        }
        assertFalse(it.hasNext())
    }


    @Test
    fun test_addAll() {
        val a = listOf(1, 2, 3, 4, 5, 6)
        val c= emptyCollection()
        a.forEach { c.add(it) }
        var expected = 7
        for (v in c) assertEquals(--expected, v)
        assertEquals(1, expected)
    }

    @Test
    fun test_contains() {
        val a = mutableListOf(1, 2, 3, 4, 5, 6)
        val c = emptyCollection()
        a.forEach { c.add(it) }
        for (e in a)
            assertTrue(c.contains(e))
        assertFalse(c.contains(7))
        c.add( 7 )
        assertTrue( c.contains(7) )
    }

    @Test
    fun test_remove() {
        val c= emptyCollection()
        for (i in 1 .. 5)
            c.add( i )
        for (i in 1 .. 5) {
            assertTrue(c.contains(i))
            c.remove(i)
            assertFalse(c.contains(i))
        }
        assertFalse(c.iterator().hasNext())
    }

}