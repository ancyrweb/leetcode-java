package leetcode_2026.product_of_array_except_self_238

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(nums: IntArray): IntArray {
    return Solution().productExceptSelf(nums)
  }

  @Test
  fun case1() {
    assertArrayEquals(
      intArrayOf(24, 12, 8, 6),
      run(intArrayOf(1, 2, 3, 4))
    )
  }

  @Test
  fun case2() {
    assertArrayEquals(
      intArrayOf(0, 0, 9, 0, 0),
      run(intArrayOf(-1, 1, 0, -3, 3))
    )
  }
}