package leetcode_2026.valid_anagram_242

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(s: String, t: String): Boolean {
    val solution = Solution()
    return solution.isAnagram(s, t)
  }

  @Test
  fun case1() {
    assertTrue(run("anagram", "nagaram"))
  }

  @Test
  fun case2() {
    assertFalse(run("rat", "car"))
  }
}