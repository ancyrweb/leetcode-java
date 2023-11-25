package binary_tree_level_order_102

import java.util.*
import kotlin.collections.ArrayList


class TreeNode(var value: Int, var left: TreeNode?, var right: TreeNode?) {}

class Solution {
  fun levelOrder(root: TreeNode?): List<List<Int>> {
    val output = ArrayList<ArrayList<Int>>();

    val queue: Queue<TreeNode> = LinkedList();

    if (root != null) {
      queue.add(root)
    }

    while (queue.size > 0) {
      val cur = ArrayList<Int>();

      for (i in queue.indices) {
        val node = queue.remove();
        cur.add(node.value);

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      output.add(cur);
    }

    return output;
  }
}