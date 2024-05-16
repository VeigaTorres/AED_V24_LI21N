package week12Trees

class AedTreeNode<T>(
    val value: T,
    var left: AedTreeNode<T>? = null,
    var right: AedTreeNode<T>? = null
)

/**
 * Count the number of nodes in a binary search tree until
 * the level k.
 * @param root root of the binary search tree
 * @param k level to count the number of nodes
 * @return number of nodes until the level k
 */
fun countNodesUntilLevel(root:AedTreeNode<Int>?, k:Int):Int {
    if( root == null ) return 0
    if ( k == 0 ) return 1
    return 1+ countNodesUntilLevel(root.left, k-1)+
              countNodesUntilLevel(root.right, k-1)
}

/**
 * Verify if exist in a binary search tree the values a and b in nodes
 * are siblings. Two nodes are siblings if they have the same parent.
 * @param root root of the binary search tree without repeated values
 * @param a value of the left node
 * @param b value of the right node
 * @return true if the values exist in nodes siblings, false otherwise
 */
fun areSiblingsInBST(root: AedTreeNode<Int>?, a:Int, b:Int):Boolean {
    if ( root == null ) return false
    if ( root.left?.value== a && root.right?.value == b) return true
    return ( root.value > b && areSiblingsInBST(root.left, a, b )) ||
            (root.value < a && areSiblingsInBST(root.right, a, b))
}

/**
 * Create a binary search tree balanced containing the values
 * from the closed range [start, end].
 * @param start initial value of the range
 * @param end final value of the range
 * @return root of the binary search tree
 */
fun createBSTFromRange(start:Int, end:Int): AedTreeNode<Int>? {
    if ( end < start ) return null
    val m = (end+start).shr( 1)
    val root = AedTreeNode<Int>( m )
    root.left = createBSTFromRange(start, m-1)
    root.right = createBSTFromRange(m+1, end)
    return root
}

/**
 * Get the n-th element of the tree.
 * @param n number of the element to get
 * @return n-th element of the tree
 */
fun <T> nesimo( root: AedTreeNode<T>?, n: Int ) : T {
     var count = 0
     fun nesimo( root: AedTreeNode<T>? ): AedTreeNode<T>? {
         if ( root == null ) return null
         val node = nesimo( root.left )
         if (node != null) return node
         ++ count
         if ( count == n ) return root
         return nesimo(root.right)
     }
    return (nesimo(root)?: throw NoSuchElementException("")).value
}

/**
 * Verify if the tree has a path to a leaf with where the sum of
 * values is the specified sum.
 * @param root root of the tree
 * @param sum value to compare
 * @return true if the tree has a path where the sum is equal to sum,
 *         false otherwise
 */
fun hasPathWithAtSum(root:AedTreeNode<Int>?, sum: Int):Boolean {
    TODO()
}


/**
 * Get the higher value in a binary search tree that is less than v.
 * @param root root of the binary search tree
 * @param v value to compare
 * @return higher value that is less than v
 */
fun <T: Comparable<T>> higher(root: AedTreeNode<T>?, v:T ): T? {
    TODO()
}