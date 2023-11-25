package kth_smallest_element_in_bst_230

import commons.TreeNode

class Solution {
  fun kthSmallest_iterative(root: TreeNode?, k: Int): Int {
    val stack = mutableListOf<TreeNode>()
    var count = 0;
    var curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }

      curr = stack.removeLast();
      count++;

      if (count == k) {
        return curr.`val`
      }

      curr = curr.right;
    }

    return 0;
  }

  fun kthSmallest_recursive(root: TreeNode?, k: Int): Int {
    val values = mutableListOf<Int>()

    fun dfs(node: TreeNode?) {
      if (node == null) {
        return;
      }

      dfs(node.left);

      if (values.size == k) {
        return;
      }

      values.add(node.`val`);
      dfs(node.right);
    }

    dfs(root);
    return values[k - 1];
  }

  fun kthSmallest(root: TreeNode?, k: Int): Int {
    return kthSmallest_iterative(root, k);
  }
}

fun main() {
  val root = TreeNode(
    30,
    TreeNode(10, null, TreeNode(20)),
    TreeNode(40)
  )

  println(Solution().kthSmallest(root, 3))
}