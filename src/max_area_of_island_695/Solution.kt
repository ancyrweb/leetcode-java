package max_area_of_island_695

class Solution {
  fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val ROWS = grid.size
    val COLS = grid[0].size

    var res = 0
    var size = 0

    fun dfs(row: Int, col: Int) {
      if (
        row < 0 || col < 0 ||
        row >= ROWS || col >= COLS ||
        grid[row][col] == 0
      ) {
        return
      }

      grid[row][col] = 0

      size++

      dfs(row - 1, col)
      dfs(row + 1, col)
      dfs(row, col - 1)
      dfs(row, col + 1)
    }

    grid.forEachIndexed { row, chars ->
      chars.forEachIndexed { col, value ->
        if (value == 1) {
          size = 0
          dfs(row, col)
          res = Math.max(size, res)
        }
      }
    }

    return res
  }
}

fun main() {
  val grid: Array<IntArray> = arrayOf(
    intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
    intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
  )

  val result = Solution().maxAreaOfIsland(grid)
  println("result : $result")
}