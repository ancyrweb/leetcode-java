package balanced_binary_tree_110

import commons.TreeNode

class Solution {
  class NodeInfo(val height: Int, val isBalanced: Boolean) {}

  fun buildNodeInfo(node: TreeNode?): NodeInfo {
    if (node == null) {
      return NodeInfo(0, true)
    }

    val leftNodeInfo = buildNodeInfo(node.left)
    val rightNodeInfo = buildNodeInfo(node.right)
    val height = 1 + Math.max(leftNodeInfo.height, rightNodeInfo.height)

    if (!leftNodeInfo.isBalanced || !rightNodeInfo.isBalanced) {
      return NodeInfo(
        height,
        false
      )
    }

    val balanced = Math.abs(leftNodeInfo.height - rightNodeInfo.height) <= 1

    return NodeInfo(height, balanced)
  }

  fun isBalanced(root: TreeNode?): Boolean {
    val result = buildNodeInfo(root)
    return result.isBalanced
  }
}