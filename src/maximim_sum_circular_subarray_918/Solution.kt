package maximim_sum_circular_subarray_918

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun maxSubarraySumCircular_long(nums: IntArray): Int {
    fun calculateRightMax(): IntArray {
      val n = nums.size
      var acc = nums[n - 1]
      val rightMax = IntArray(n)

      rightMax[n - 1] = nums[n - 1]

      for (i in n - 2 downTo 0) {
        acc += nums[i]
        rightMax[i] = Math.max(rightMax[i + 1], acc)
      }

      return rightMax
    }

    val n = nums.size
    val rightMax = calculateRightMax()

    var prefixSum = 0
    var specialSum = nums[0]
    var normalSum = nums[0]
    var curr = 0

    for (i in nums.indices) {
      curr = Math.max(curr, 0) + nums[i]
      normalSum = Math.max(normalSum, curr)

      prefixSum += nums[i]
      if (i + 1 < n) {
        specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1])
      }
    }

    return Math.max(normalSum, specialSum)
  }


  fun maxSubarraySumCircular(nums: IntArray): Int {
    var curMin = 0
    var curMax = 0
    var total = 0
    var sumMin = nums[0]
    var sumMax = nums[0]

    for (i in nums.indices) {
      curMax = Math.max(curMax, 0) + nums[i]
      curMin = Math.min(curMin, 0) + nums[i]
      total += nums[i]
      sumMax = Math.max(sumMax, curMax)
      sumMin = Math.min(sumMin, curMin)
    }

    if (total == sumMin) {
      return sumMax
    }

    return Math.max(sumMax, total - sumMin)
  }

  @Test
  fun case1() {
    assertEquals(
      3,
      maxSubarraySumCircular(
        intArrayOf(1, -2, 3, -2)
      )
    )
  }

  @Test
  fun case2() {
    assertEquals(
      10,
      maxSubarraySumCircular(
        intArrayOf(5, -3, 5)
      )
    )
  }

  @Test
  fun case3() {
    assertEquals(
      -2,
      maxSubarraySumCircular(
        intArrayOf(-3, -2, -3)
      )
    )
  }

  @Test
  fun case83() {
    assertEquals(
      152,
      maxSubarraySumCircular(
        intArrayOf(
          5,
          -19,
          10,
          -15,
          22,
          -2,
          -11,
          28,
          -29,
          10,
          1,
          2,
          22,
          -23,
          -9,
          -30,
          -6,
          -9,
          1,
          8,
          24,
          2,
          21,
          29,
          10,
          -25,
          18,
          30,
          1,
          9
        )
      )
    )
  }
}