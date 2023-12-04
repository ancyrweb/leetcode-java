package remove_dup_from_sorted_array_26

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun removeDuplicates(nums: IntArray): Int {
    var lastIndex = 0

    for (i in 1 until nums.size) {
      if (nums[i] == nums[lastIndex]) {
        continue
      }

      lastIndex++
      nums[lastIndex] = nums[i]
    }

    return lastIndex + 1
  }

  @Test
  fun case2() {
    var array = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    var result = removeDuplicates(array)

    assertEquals(
      5,
      result
    )

    assertEquals(0, array[0])
    assertEquals(1, array[1])
    assertEquals(2, array[2])
    assertEquals(3, array[3])
    assertEquals(4, array[4])
  }
}