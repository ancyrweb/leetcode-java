package leetcode_2026.kth_largest_element_703

import java.util.*

class KthLargest(val k: Int, nums: IntArray) {
  val q = PriorityQueue<Int>()

  init {
    for (n in nums) {
      q.offer(n)
    }

    while (q.size > k) {
      q.poll()
    }
  }

  fun add(`val`: Int): Int {
    q.offer(`val`)

    // This loop protects against the case  where the initial array contains
    // less elements than k.
    while (q.size > k) {
      q.poll()
    }

    return q.peek()
  }
}