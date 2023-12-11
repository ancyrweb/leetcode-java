package element_appearing_more_25_1287

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun findSpecialInteger(arr: IntArray): Int {
    val k = arr.size / 4
    for (i in 0 until arr.size - k) {
      if (arr[i] == arr[i + k]) {
        return arr[i]
      }
    }

    return arr[0]
  }

  @Test
  fun case12() {
    assertEquals(
      12,
      findSpecialInteger(
        (intArrayOf(
          1,
          2,
          3,
          4,
          5,
          6,
          7,
          8,
          9,
          10,
          11,
          12,
          12,
          12,
          12
        ))
      )
    )
  }

  @Test
  fun case13() {
    assertEquals(
      6,
      findSpecialInteger(
        (intArrayOf(
          1, 2, 2, 6, 6, 6, 6, 7, 10
        ))
      )
    )
  }
}