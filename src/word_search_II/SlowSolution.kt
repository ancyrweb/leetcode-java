package word_search_II

class SlowSolution {
  fun findWord(board: Array<CharArray>, word: String): Boolean {
    val backtrack = HashSet<String>()
    val ROWS = board.size
    val COLS = board[0].size

    fun dfs(row: Int, col: Int, charIndex: Int): Boolean {
      if (charIndex >= word.length) {
        return true
      }

      if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
        return false
      }

      if (backtrack.contains("$row|$col")) {
        return false
      }

      val c = board[row][col]
      if (c != word[charIndex]) {
        return false
      }

      backtrack.add("$row|$col")

      val result = dfs(row - 1, col, charIndex + 1) ||
          dfs(row + 1, col, charIndex + 1) ||
          dfs(row, col - 1, charIndex + 1) ||
          dfs(row, col + 1, charIndex + 1)

      backtrack.remove("$row|$col")

      return result
    }

    for (row in 0 until board.size) {
      for (col in 0 until board[row].size) {
        if (dfs(row, col, 0)) {
          return true
        }
      }
    }

    return false
  }

  fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    var list = mutableListOf<String>()

    for (word in words) {
      if (findWord(board, word)) {
        list.add(word)
      }
    }

    return list
  }
}