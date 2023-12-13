package special_positions_in_binary_matrix_1582

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun numSpecial(mat: Array<IntArray>): Int {
    val rows = mat.size
    val cols = mat[0].size
    val rowMap = Array<Int>(rows) { 0 }
    val colMap = Array<Int>(cols) { 0 }

    for (r in 0 until rows) {
      for (c in 0 until cols) {
        if (mat[r][c] == 1) {
          rowMap[r]++
          colMap[c]++
        }
      }
    }

    var count = 0

    for (r in 0 until rows) {
      for (c in 0 until cols) {
        if (mat[r][c] == 1 && rowMap[r] == 1 && colMap[c] == 1) {
          count++
        }
      }
    }

    return count
  }

  @Test
  fun case1() {
    assertEquals(
      1,
      numSpecial(
        arrayOf(
          intArrayOf(1, 0, 0),
          intArrayOf(0, 0, 1),
          intArrayOf(1, 0, 0)
        )
      )
    )
  }
}