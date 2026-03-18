package leetcode_2026.kth_largest_element_in_array_215

import java.util.*

class Solution {
  fun findKthLargest(nums: IntArray, k: Int): Int = findKthLargestWithMinHeap(nums, k)

  fun findKthLargestWithSort(nums: IntArray, k: Int): Int {
    return nums.sortedByDescending { it }[k - 1]
  }

  fun findKthLargestWithMaxHeap(nums: IntArray, k: Int): Int {
    val q = PriorityQueue<Int>(Collections.reverseOrder())
    for (n in nums) {
      q.offer(n)
    }

    for (i in 1 until k) {
      q.poll()
    }

    return q.poll()!!
  }

  fun findKthLargestWithMinHeap(nums: IntArray, k: Int): Int {
    val q = PriorityQueue<Int>()
    for (n in nums) {
      q.offer(n)
      if (q.size > k) {
        q.poll()
      }
    }

    return q.poll()!!
  }
}