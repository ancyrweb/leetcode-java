package leetcode_2025.two_sum_1

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(nums: IntArray, target: Int): IntArray {
    return Solution().twoSum(nums, target)
  }

  @Test
  fun case1() {
    assertArrayEquals(
      intArrayOf(0, 1),
      run(intArrayOf(2, 7, 11, 15), 9)
    )
  }

  @Test
  fun case2() {
    assertArrayEquals(
      intArrayOf(1, 2),
      run(intArrayOf(3, 2, 4), 6)
    )
  }

  @Test
  fun case3() {
    assertArrayEquals(
      intArrayOf(0, 1),
      run(intArrayOf(3, 3), 6)
    )
  }
}