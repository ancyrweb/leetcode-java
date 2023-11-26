package shortest_path_binary_matrix_1091

import java.util.*

class Solution {
  fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val ROWS = grid.size
    val COLS = grid[0].size

    val directions: Array<Pair<Int, Int>> = arrayOf(
      Pair(-1, 0),
      Pair(1, 0),
      Pair(0, -1),
      Pair(0, 1),
      Pair(-1, -1),
      Pair(-1, 1),
      Pair(1, -1),
      Pair(1, 1)
    )

    var result = 1
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))

    while (!queue.isEmpty()) {
      for (i in 0 until queue.size) {
        val (row, col) = queue.remove()

        if (grid[row][col] == 1) {
          continue
        }

        if (row == ROWS - 1 && col == COLS - 1) {
          return result
        }

        grid[row][col] = 1

        for (dir in directions) {
          val nextRow = row + dir.first
          val nextCol = col + dir.second

          if (
            nextRow >= 0 && nextCol >= 0 &&
            nextRow < ROWS && nextCol < COLS &&
            grid[nextRow][nextCol] == 0
          ) {
            queue.add(Pair(nextRow, nextCol))
          }
        }
      }

      result++
    }

    return -1
  }
}

fun main() {
  var result = Solution().shortestPathBinaryMatrix(
    arrayOf(
      intArrayOf(0, 1),
      intArrayOf(1, 0),
    )
  )

  println("result : $result")
}