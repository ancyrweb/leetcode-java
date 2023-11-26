package last_stone_weight_1046

import java.util.*

class Solution {
  fun lastStoneWeight(stones: IntArray): Int {
    val queue = PriorityQueue<Int>()
    queue.addAll(stones.map { -it });

    while (queue.size > 1) {
      val result = queue.remove() - queue.remove()
      if (result != 0) {
        queue.add(result)
      }
    }

    return if (queue.size == 0) 0 else -queue.peek()
  }
}