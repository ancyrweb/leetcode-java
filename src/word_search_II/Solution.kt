package word_search_II

class Solution {
  class Node {
    public val map = HashMap<Char, Node>()
    public var word: String? = null

    fun match(c: Char): Boolean {
      return map.containsKey((c))
    }
  }

  fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val list = HashSet<String>()
    val root = Node()

    val backtrack = HashSet<String>()
    val ROWS = board.size
    val COLS = board[0].size

    fun insert(word: String) {
      var curr = root
      for (c in word) {
        if (!curr.match(c)) {
          curr.map[c] = Node()
        }

        curr = curr.map[c]!!
      }

      curr.word = word
    }

    fun search(row: Int, col: Int, node: Node) {
      if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
        return
      }

      if (backtrack.contains("$row|$col")) {
        return
      }

      if (!node.match(board[row][col])) {
        return
      }

      val nextNode = node.map[board[row][col]]
      if (nextNode!!.word != null) {
        list.add(nextNode.word!!)
      }

      backtrack.add("$row|$col")

      search(row - 1, col, nextNode)
      search(row + 1, col, nextNode)
      search(row, col - 1, nextNode)
      search(row, col + 1, nextNode)

      backtrack.remove("$row|$col")
    }

    for (word in words) {
      insert(word)
    }

    for (row in 0 until ROWS) {
      for (col in 0 until COLS) {
        search(row, col, root)
      }
    }

    return list.toList()
  }
}