package leetcode_2026.topk_frequent_elements_347

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(nums: IntArray, k: Int): IntArray {
    return Solution().topKFrequent(nums, k)
  }

  @Test
  fun case1() {
    assertArrayEquals(run(intArrayOf(1, 1, 1, 2, 2, 3), 2), intArrayOf(1, 2))
  }

  @Test
  fun case3() {
    assertArrayEquals(run(intArrayOf(1), 1), intArrayOf(1))
  }
}