package leetcode_2026.k_closest_points_to_origin_973

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(points: Array<IntArray>, k: Int): Array<IntArray> {
    return Solution().kClosest(points, k)
  }

  private fun assertArrayContains(output: Array<IntArray>, array: IntArray) {
    val element = output.find { it[0] == array[0] && it[1] == array[1] }
    assertNotNull(element)
  }

  @Test
  fun case1() {
    val out = run(
      arrayOf(
        intArrayOf(1, 3),
        intArrayOf(-2, 2)
      ),
      1
    )

    assertEquals(out.size, 1)
    assertArrayContains(out, intArrayOf(-2, 2))
  }

  @Test
  fun case2() {
    val out = run(
      arrayOf(
        intArrayOf(3, 3),   // sqrt(18)
        intArrayOf(5, -1),  // sqrt(26)
        intArrayOf(-2, 4)   // sqrt(20)
      ),
      2
    )

    assertEquals(out.size, 2)
    assertArrayContains(out, intArrayOf(3, 3))
    assertArrayContains(out, intArrayOf(-2, 4))
  }
}