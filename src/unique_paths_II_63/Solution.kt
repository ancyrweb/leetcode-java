package unique_paths_II_63

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val ROWS = obstacleGrid.size
    val COLS = obstacleGrid[0].size

    val prev = Array<Int>(COLS) { 0 }

    for (i in COLS - 1 downTo 0) {
      if (obstacleGrid[ROWS - 1][i] == 1) {
        prev[i] = 0
      } else {
        if (i == COLS - 1) {
          prev[i] = 1
        } else {
          prev[i] = prev[i + 1]
        }
      }
    }

    for (i in ROWS - 2 downTo 0) {
      for (j in COLS - 1 downTo 0) {
        if (obstacleGrid[i][j] == 1) {
          prev[j] = 0
        } else {
          if (j == COLS - 1) {
            prev[j] = prev[j]
          } else {
            prev[j] = prev[j] + prev[j + 1]
          }
        }
      }
    }

    return prev[0]
  }

  @Test
  fun test_case_1() {
    assertEquals(
      2,
      uniquePathsWithObstacles(
        arrayOf(
          intArrayOf(0, 0, 0),
          intArrayOf(0, 1, 0),
          intArrayOf(0, 0, 0)
        )
      )
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      1,
      uniquePathsWithObstacles(
        arrayOf(
          intArrayOf(0, 1),
          intArrayOf(0, 0),
        )
      )
    )
  }

  @Test
  fun test_case_32() {
    assertEquals(
      0,
      uniquePathsWithObstacles(
        arrayOf(
          intArrayOf(0, 0),
          intArrayOf(0, 1),
        )
      )
    )
  }
}