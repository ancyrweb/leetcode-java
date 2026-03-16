package leetcode_2026.last_stone_weight_1046

import java.util.*

class Solution {
  fun lastStoneWeight(stones: IntArray): Int {
    val q = PriorityQueue<Int>(Collections.reverseOrder())
    for (i in stones) {
      q.offer(i)
    }

    while (q.size > 1) {
      val r = q.poll() - q.poll()
      if (r != 0) {
        q.offer(r)
      }
    }

    return if (q.isEmpty()) 0 else q.poll()
  }
}