package path_sum_112

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

class Solution {
  fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
      return false;
    }

    if (
      root.`val` == targetSum &&
      root.left == null &&
      root.right == null
    ) {
      return true;
    }

    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
  }
}