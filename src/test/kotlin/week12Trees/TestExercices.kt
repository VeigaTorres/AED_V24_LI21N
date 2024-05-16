package week12Trees

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TestExercices {

    private fun createBSTAllRight(start: Int, end: Int): AedTreeNode<Int> {
        val tree = AedTreeNode(start)
        var curr: AedTreeNode<Int>? = tree
        for (v in start + 1..end) {
            curr?.right = AedTreeNode(v)
            curr = curr?.right
        }
        return tree
    }

    private fun createBSTAllLeft(start: Int, end: Int): AedTreeNode<Int> {
        val tree = AedTreeNode(end)
        var curr: AedTreeNode<Int>? = tree
        for (v in end - 1 downTo start) {
            curr?.left = AedTreeNode(v)
            curr = curr?.left
        }
        return tree
    }

    @Test
    fun test_countNodesUntilLevel() {
        val N = 7
        fun testN(tree: AedTreeNode<Int>?) {
            for (n in 1..N)
                assertEquals(n, countNodesUntilLevel(tree, n - 1))
        }
        assertEquals(1, countNodesUntilLevel(AedTreeNode(1), 0))
        assertEquals(1, countNodesUntilLevel(AedTreeNode(1), 3))
        testN(createBSTAllLeft(1, N))
        testN(createBSTAllLeft(1, N))
        val tree = createBSTFromRange(1, N)
        assertEquals(1, countNodesUntilLevel(tree, 0))
        assertEquals(3, countNodesUntilLevel(tree, 1))
        assertEquals(7, countNodesUntilLevel(tree, 2))
        assertEquals(7, countNodesUntilLevel(tree, 3))
    }


    @Test
    fun test_areSiblingsInBST() {
        assertFalse(areSiblingsInBST(null, 2, 3))
        assertFalse(areSiblingsInBST(AedTreeNode(1), 2, 3))
        assertTrue(areSiblingsInBST(createBSTFromRange(1, 3), 1, 3))
        assertTrue(areSiblingsInBST(createBSTFromRange(1, 7), 2, 6))
        assertTrue(areSiblingsInBST(createBSTFromRange(1, 7), 1, 3))
        assertTrue(areSiblingsInBST(createBSTFromRange(1, 7), 5, 7))
        assertFalse(areSiblingsInBST(createBSTFromRange(1, 7), 4, 7))
    }

    @Test
    fun test_nesimo() {
        val N = 7
        fun testN(tree: AedTreeNode<Int>?) {
            for (n in 1..N)
                assertEquals(n, nesimo(tree, n))
        }
        assertEquals("one", nesimo(AedTreeNode<String>("one"), 1))
        val tree = createBSTFromRange(1, N)
        testN(tree)
        testN(createBSTAllRight(1, N))
        testN(createBSTAllLeft(1, N))
        assertThrows<NoSuchElementException> { nesimo(null, 0) }
        assertThrows<NoSuchElementException> { nesimo(tree, N + 2) }
    }

    @Test
    fun test_createBSTFromRange() {
        assertEquals(2, createBSTFromRange(1, 3)?.value)
        assertEquals(7, createBSTFromRange(6, 8)?.value)
        assertEquals(6, createBSTFromRange(3, 10)?.value)
    }
}