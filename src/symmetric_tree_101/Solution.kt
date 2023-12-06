package symmetric_tree_101

import commons.TreeNode
import java.util.*

class Solution {
  fun isSymmetric_bfs(root: TreeNode?): Boolean {
    if (root == null) {
      return true
    }

    var stack = LinkedList<TreeNode?>()
    stack.add(root.left)
    stack.add(root.right)


    while (stack.isNotEmpty()) {
      val next = LinkedList<TreeNode?>()

      for (i in 0 until stack.size / 2) {
        val left = stack[i]
        val right = stack[stack.size - i - 1]

        if (left?.`val` != right?.`val`) {
          return false
        }

        if (left != null && right != null) {
          next.addFirst(left.right)
          next.addFirst(left.left)
          next.add(right.left)
          next.add(right.right)
        }
      }

      stack = next
    }

    return true
  }

  fun isSymmetric(root: TreeNode?): Boolean {
    fun dfs(a: TreeNode?, b: TreeNode?): Boolean {
      if (a == null || b == null) {
        return a == null && b == null
      }

      if (a.`val` != b.`val`) {
        return false
      }

      return dfs(a.left, b.right) && dfs(a.right, b.left)
    }

    return dfs(root?.left, root?.right)
  }

}