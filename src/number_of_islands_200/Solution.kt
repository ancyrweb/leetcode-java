package number_of_islands_200

class Solution {
  fun numIslands_dfs(grid: Array<CharArray>): Int {
    val ROWS = grid.size
    val COLS = grid[0].size
    var count = 0

    fun dfs(row: Int, col: Int) {
      if (
        row < 0 || col < 0 ||
        row >= ROWS || col >= COLS ||
        grid[row][col] == '0'
      ) {
        return
      }

      grid[row][col] = '0'

      dfs(row - 1, col)
      dfs(row + 1, col)
      dfs(row, col - 1)
      dfs(row, col + 1)
    }

    grid.forEachIndexed { row, chars ->
      chars.forEachIndexed { col, character ->
        if (character == '1') {
          dfs(row, col)
          count++
        }
      }
    }

    return count
  }


  fun numIslands_dfs_hashSet(grid: Array<CharArray>): Int {
    val ROWS = grid.size
    val COLS = grid[0].size

    val visit = HashSet<String>()
    var count = 0

    fun hash(a: Int, b: Int): String {
      return "$a|$b"
    }

    fun contains(a: Int, b: Int): Boolean {
      return visit.contains(hash(a, b))
    }

    fun dfs(row: Int, col: Int) {
      if (
        row < 0 || col < 0 ||
        row >= ROWS || col >= COLS ||
        contains(row, col) ||
        grid[row][col] == '0'
      ) {
        return
      }

      visit.add(hash(row, col))

      dfs(row - 1, col)
      dfs(row + 1, col)
      dfs(row, col - 1)
      dfs(row, col + 1)
    }

    grid.forEachIndexed { row, chars ->
      chars.forEachIndexed { col, character ->
        if (character == '1' && !contains(row, col)) {
          dfs(row, col)
          count++
        }
      }
    }

    return count
  }

  fun numIslands(grid: Array<CharArray>): Int {
    return numIslands_dfs(grid)
  }
}

fun main() {
  val grid: Array<CharArray> = arrayOf(
    charArrayOf('1', '1', '0', '0', '0'),
    charArrayOf('1', '1', '0', '0', '0'),
    charArrayOf('0', '0', '1', '0', '0'),
    charArrayOf('0', '0', '0', '1', '1')
  )

  val result = Solution().numIslands(grid)
  println("result : $result")
}