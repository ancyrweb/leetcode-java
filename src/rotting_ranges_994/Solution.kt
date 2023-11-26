package rotting_ranges_994

import java.util.*


class Solution {
  fun orangesRotting(grid: Array<IntArray>): Int {
    val directions: Array<Pair<Int, Int>> = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    val ROWS = grid.size
    val COLS = grid[0].size

    var result = 0
    var fresh = 0

    fun bfs() {
      val queue: Queue<Pair<Int, Int>> = LinkedList()
      grid.forEachIndexed { row, chars ->
        chars.forEachIndexed { col, c ->
          if (c == 2) {
            queue.add(Pair(row, col))
          } else if (c == 1) {
            fresh++
          }
        }
      }

      if (!queue.isEmpty()) {
        result = -1
      }

      while (!queue.isEmpty()) {
        result++
        for (i in 0 until queue.size) {
          val p = queue.remove()
          for (dir in directions) {
            val nextRow = p.first + dir.first
            val nextCol = p.second + dir.second

            if (
              nextRow >= 0 && nextCol >= 0 &&
              nextRow < ROWS && nextCol < COLS &&
              grid[nextRow][nextCol] == 1
            ) {
              fresh--
              grid[nextRow][nextCol] = 2
              queue.add(Pair(nextRow, nextCol))
            }
          }
        }
      }
    }

    bfs()

    if (fresh > 0) {
      return -1
    }

    return result
  }
}

fun main() {
  val result = Solution().orangesRotting(
    arrayOf(
      intArrayOf(0)
    )
  )

  println("result : $result")
}