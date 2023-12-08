package range_sum_query_2D_304

class NumMatrix(private val matrix: Array<IntArray>) {
  private val prefix: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size + 1) }

  init {
    for (row in matrix.indices) {
      for (col in matrix[row].indices) {
        this.prefix[row][col + 1] = this.prefix[row][col] + matrix[row][col]
      }
    }
  }

  private fun sumLine(row: Int, start: Int, end: Int): Int {
    return this.prefix[row][end + 1] - this.prefix[row][start]
  }

  fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
    var sum = 0

    for (i in row1..row2) {
      sum += sumLine(i, col1, col2)
    }

    return sum
  }
}