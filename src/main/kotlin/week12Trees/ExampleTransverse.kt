package week12Trees

class TreeNode<E>(val value: E,
                  var left: TreeNode<E>? = null,
                  var right: TreeNode<E>? = null)

fun <E> inorderTreeWalk(root: TreeNode<E>? ) {
    if (root != null ) {
      inorderTreeWalk( root.left )
      print("${root.value} ")
      inorderTreeWalk( root.right )
    }
}

fun main() {
    val left = TreeNode(13, TreeNode(8), TreeNode(14))
    val right = TreeNode(19, right = TreeNode(33))
    val tree = TreeNode(15, left, right)
    inorderTreeWalk( tree )
}