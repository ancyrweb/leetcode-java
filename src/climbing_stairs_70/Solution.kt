package climbing_stairs_70

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun climbStairs_recursive(n: Int): Int {
    if (n <= 3) {
      return n
    }

    return climbStairs(n - 1) + climbStairs(n - 2)
  }

  fun climbStairs_cached(n: Int): Int {
    fun work(n: Int, cache: HashMap<Int, Int>): Int {
      if (n <= 3) {
        return n
      }

      if (!cache.containsKey(n)) {
        cache[n] = work(n - 1, cache) + work(n - 2, cache)
      }

      return cache[n]!!
    }


    return work(n, HashMap<Int, Int>())
  }

  fun climbStairs_reverse(n: Int): Int {
    val dp = intArrayOf(1, 0)

    for (i in n - 1 downTo 0) {
      val result = dp[1] + dp[0]
      dp[1] = dp[0]
      dp[0] = result
    }

    return dp[0]
  }

  fun climbStairs(n: Int): Int {
    fun fib(n: Int): Int {
      val dp = intArrayOf(0, 1)

      for (i in 0 until n) {
        val result = dp[0] + dp[1]
        dp[0] = dp[1]
        dp[1] = result
      }

      return dp[1]
    }

    return fib(n)
  }

  @Test
  fun test_case_1() {
    assertEquals(climbStairs(2), 2)
  }

  @Test
  fun test_case_2() {
    assertEquals(climbStairs(3), 3)
  }

  @Test
  fun test_case_3() {
    assertEquals(climbStairs(4), 5)
  }

  @Test
  fun test_case_4() {
    assertEquals(climbStairs(5), 8)
  }

  @Test
  fun test_case_5() {
    assertEquals(climbStairs(1), 1)
  }
}