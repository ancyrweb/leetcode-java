package leetcode_2025.contains_duplicate_217

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(input: IntArray): Boolean {
    val solution = Solution()
    return solution.containsDuplicate(input)
  }

  @Test
  fun case1() {
    assertTrue(run(intArrayOf(1, 2, 3, 1)))
  }

  @Test
  fun case2() {
    assertFalse(run(intArrayOf(1, 2, 3, 4)))
  }

  @Test
  fun case3() {
    assertTrue(run(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
  }
}