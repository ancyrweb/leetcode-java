package binary_tree_right_side_view_199

import java.util.*
import kotlin.collections.ArrayList

class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?) {}

class Solution {
  fun rightSideView(root: TreeNode?): List<Int> {
    val output = ArrayList<Int>();
    val queue: Queue<TreeNode> = LinkedList();

    if (root != null) {
      queue.add(root)
    }

    while (queue.size > 0) {
      val size = queue.size;
      for (i in 0 until size) {
        val node = queue.remove();
        if (i == size - 1) {
          output.add(node.`val`);
        }

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return output;
  }
}