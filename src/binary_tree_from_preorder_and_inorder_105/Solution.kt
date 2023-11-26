package binary_tree_from_preorder_and_inorder_105

import commons.TreeNode
import java.util.*

// Note : this problem is ranked medium but is actually Hard
class Solution {
  fun buildTreeSlicingArrays(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty()) {
      return null
    }

    val index = inorder.indexOf(preorder.first())

    return TreeNode(
      preorder.first(),
      buildTreeSlicingArrays(
        preorder.sliceArray(1..index),
        inorder.sliceArray(0 until index)
      ),
      buildTreeSlicingArrays(
        preorder.sliceArray(index + 1 until preorder.size),
        inorder.sliceArray(index + 1 until inorder.size)
      )
    )
  }


  fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    var currentInOrder = 0
    var currentPreOrder = 1

    val root = TreeNode(preorder[0])
    val stack = Stack<Int>().apply { this.add(preorder[0]) }

    fun hasNext() = currentInOrder < inorder.size && currentPreOrder < preorder.size
    fun nextInorder() = if (currentInOrder >= inorder.size) null else inorder[currentInOrder]
    fun stackPeekOrNull() = if (stack.isEmpty()) null else stack.peek()

    fun dfs(curNode: TreeNode) {
      if (hasNext() && nextInorder() != curNode.`val`) {
        curNode.left = TreeNode(preorder[currentPreOrder++])
        stack.push(curNode.left!!.`val`)
        dfs(curNode.left!!)
      }

      if (nextInorder() == curNode.`val`) {
        currentInOrder++
        stack.pop()
        if (currentInOrder >= inorder.size) return
      }

      if (nextInorder() == stackPeekOrNull()) {
        return
      }

      if (nextInorder() != curNode.`val` && nextInorder() != stackPeekOrNull()) {
        curNode.right = TreeNode(preorder[currentPreOrder++])
        stack.push(curNode.right!!.`val`)
        dfs(curNode.right!!)
      }
    }

    dfs(root)

    return root
  }


}

fun main() {
  val tree = TreeNode(
    3,
    TreeNode(9),
    TreeNode(
      20,
      TreeNode(15),
      TreeNode(7)
    )
  )


  val rebuilt = Solution().buildTree(
    tree.preOrder().toIntArray(),
    tree.inOrder().toIntArray()
  )

  println(rebuilt?.preOrder());
  println(rebuilt?.inOrder());
}