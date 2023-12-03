package unique_paths_62

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun uniquePaths(m: Int, n: Int): Int {
    val prev = Array(n) { 1 }

    for (i in m - 2 downTo 0) {
      for (j in n - 2 downTo 0) {
        prev[j] = prev[j] + prev[j + 1]
      }
    }

    return prev[0]
  }

  @Test
  fun test_case_1() {
    assertEquals(
      28,
      uniquePaths(3, 7)
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      3,
      uniquePaths(3, 2)
    )
  }
}