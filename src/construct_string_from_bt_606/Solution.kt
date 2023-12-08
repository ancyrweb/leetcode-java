package construct_string_from_bt_606

import commons.TreeNode

class Solution {
  fun tree2str(root: TreeNode?): String {
    val builder = StringBuilder()

    fun traverse(node: TreeNode?) {
      if (node == null) {
        return
      }

      builder.append(node.`val`)

      if (node!!.left != null) {
        builder.append("(")
        traverse(node.left)
        builder.append(")")
      }

      if (node!!.right != null) {
        if (node!!.left == null) {
          builder.append("()")
        }

        builder.append("(")
        traverse(node.right)
        builder.append(")")
      }

    }

    traverse(root)
    return builder.toString()

  }
}