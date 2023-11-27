package valid_sudoku_36

class Solution {
  fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows: Array<HashSet<Char>> = arrayOf(
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
    )

    val cols: Array<HashSet<Char>> = arrayOf(
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
      HashSet(),
    )

    val boxes: Array<Array<HashSet<Char>>> = arrayOf(
      arrayOf(
        HashSet(),
        HashSet(),
        HashSet(),
      ),
      arrayOf(
        HashSet(),
        HashSet(),
        HashSet(),
      ),
      arrayOf(
        HashSet(),
        HashSet(),
        HashSet(),
      )
    )

    for (row in 0 until board.size) {
      for (col in 0 until board[row].size) {
        val c = board[row][col]
        if (c == '.') {
          continue
        }

        val boxRow = row / 3
        val colRow = col / 3

        if (
          rows[row].contains(c) ||
          cols[col].contains((c)) ||
          boxes[boxRow][colRow].contains(c)
        ) {
          return false
        }


        rows[row].add(c)
        cols[col].add(c)
        boxes[boxRow][colRow].add(c)
      }
    }

    return true
  }
}