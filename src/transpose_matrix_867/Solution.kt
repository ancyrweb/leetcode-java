package transpose_matrix_867

class Solution {
  fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val m = matrix.size
    val n = matrix[0].size

    val next = Array<IntArray>(n) { IntArray(m) }

    for (i in 0 until m) {
      for (j in 0 until n) {
        next[j][i] = matrix[i][j]
      }
    }

    return next
  }
}