package leetcode_2026.kth_largest_element_in_array_215

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(nums: IntArray, k: Int): Int {
    return Solution().findKthLargest(nums, k)
  }

  @Test
  fun case1() {
    assertEquals(
      5,
      run(
        nums = intArrayOf(3, 2, 1, 5, 6, 4),
        k = 2
      )
    )
  }

  @Test
  fun case2() {
    assertEquals(
      4,
      run(
        nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6),
        k = 4
      )
    )
  }


}