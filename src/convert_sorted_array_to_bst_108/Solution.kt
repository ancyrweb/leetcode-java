package convert_sorted_array_to_bst_108

import commons.TreeNode

class Solution {
  class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
      fun build(start: Int, end: Int): TreeNode? {
        if (end - start < 0) {
          return null
        }

        if (end - start == 0) {
          return TreeNode(nums[start])
        }

        if (end - start == 1) {
          val a = nums[start]
          val b = nums[end]

          val node = TreeNode(Math.max(a, b))
          node.left = TreeNode(Math.min(a, b))
          return node
        }

        var pivot: Int = Math.floor((start + end) / 2.0).toInt()
        if (start + end % 2 == 1) {
          pivot += 1
        }

        val node = TreeNode(nums[pivot])
        node.left = build(start, pivot - 1)
        node.right = build(pivot + 1, end)
        return node
      }

      return build(0, nums.size - 1)
    }
  }
}