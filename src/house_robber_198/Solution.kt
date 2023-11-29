package house_robber_198

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Solution {
  fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
      return 0
    }

    val memo = Array<Int>(nums.size + 3) { _ -> 0 }
    for (i in nums.size - 1 downTo 0) {
      memo[i] = nums[i] + Math.max(memo[i + 2], memo[i + 3])
    }

    return Math.max(memo[0], memo[1])
  }

  @Test
  fun test_case_1() {
    Assertions.assertEquals(rob(intArrayOf(1, 2, 3, 1)), 4)
  }

  @Test
  fun test_case_2() {
    Assertions.assertEquals(rob(intArrayOf(2, 7, 9, 3, 1)), 12)
  }

  @Test
  fun test_case_55() {
    Assertions.assertEquals(rob(intArrayOf(1, 2)), 2)
  }

}