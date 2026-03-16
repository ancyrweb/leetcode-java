package leetcode_2026.last_stone_weight_1046

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  @Test
  fun case1() {
    val out = Solution().lastStoneWeight((intArrayOf(1)))
    assertEquals(1, out)
  }

  @Test
  fun case2() {
    val out = Solution().lastStoneWeight((intArrayOf(2, 7, 4, 1, 8, 1)))
    assertEquals(1, out)
  }
}