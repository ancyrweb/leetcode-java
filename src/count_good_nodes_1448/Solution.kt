package count_good_nodes_1448

import commons.TreeNode

class Solution {
  fun goodNodes(root: TreeNode?): Int {
    var count = 0

    fun dfs(node: TreeNode?, max: Int) {
      if (node === null) {
        return
      }

      if (node.`val` >= max) {
        count++
      }

      val newMax = Math.max(max, node.`val`)
      dfs(node.left, newMax)
      dfs(node.right, newMax)
    }

    dfs(root, Int.MIN_VALUE)

    return count
  }
}