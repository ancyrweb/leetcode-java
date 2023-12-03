package minimum_time_visiting_all_points_1266

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

class Solution {
  fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var steps = 0

    for (i in 1 until points.size) {
      val deltaX = abs(points[i][0] - points[i - 1][0])
      val deltaY = abs(points[i][1] - points[i - 1][1])
      steps += deltaX.coerceAtLeast(deltaY)
    }

    return steps
  }

  @Test
  fun test_case_1() {
    assertEquals(
      7,
      minTimeToVisitAllPoints(
        arrayOf(
          intArrayOf(1, 1),
          intArrayOf(3, 4),
          intArrayOf(-1, 0)
        )
      )
    )
  }
}