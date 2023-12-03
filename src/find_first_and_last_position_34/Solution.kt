package find_first_and_last_position_34

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Solution {
  fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.size == 0) {
      return intArrayOf(-1, -1)
    }

    var pivot = Math.floor(nums.size / 2.0).toInt()
    var upper = nums.size - 1
    var lower = 0

    while (nums[pivot] != target && upper > lower) {
      if (nums[pivot] > target) {
        upper = pivot - 1
      } else {
        lower = pivot + 1
      }

      pivot = Math.floor((upper + lower) / 2.0).toInt()
    }

    if (nums[pivot] != target) {
      return intArrayOf(-1, -1)
    }

    upper = pivot
    lower = pivot

    while (lower > 0 && nums[lower - 1] == target) {
      lower--
    }
    while (upper < nums.size - 1 && nums[upper + 1] == target) {
      upper++
    }

    return intArrayOf(lower, upper)
  }

  @Test
  fun test_case_1() {
    assertArrayEquals(
      intArrayOf(3, 4),
      searchRange(
        intArrayOf(5, 7, 7, 8, 8, 10),
        8
      )
    )
  }

  @Test
  fun test_case_2() {
    assertArrayEquals(
      intArrayOf(-1, -1),
      searchRange(
        intArrayOf(5, 7, 7, 8, 8, 10),
        6
      )
    )
  }

  @Test
  fun test_case_3() {
    assertArrayEquals(
      intArrayOf(-1, -1),
      searchRange(
        intArrayOf(),
        0
      )
    )
  }

  @Test
  fun test_case_6() {
    assertArrayEquals(
      intArrayOf(-1, -1),
      searchRange(
        intArrayOf(2, 2),
        3
      )
    )
  }

  @Test
  fun test_case_81() {
    assertArrayEquals(
      intArrayOf(0, 0),
      searchRange(
        intArrayOf(1, 3),
        1
      )
    )
  }
}