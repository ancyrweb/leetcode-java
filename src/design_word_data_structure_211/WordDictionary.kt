package design_word_data_structure_211

class Node {
  public val map = HashMap<Char, Node>()
  public var isWord = false
}

class WordDictionary() {
  private val root = Node()

  fun addWord(word: String) {
    var cur: Node = root

    for (c in word) {
      if (!cur.map.containsKey(c)) {
        cur.map[c] = Node()
      }
      cur = cur.map[c]!!
    }

    cur.isWord = true
  }

  fun search(word: String): Boolean {
    fun dfs(node: Node, index: Int): Boolean {
      var cur = node
      for (i in index until word.length) {
        val c = word[i]
        if (c == '.') {
          for (key in cur.map.keys) {
            if (dfs(cur.map[key]!!, i + 1)) {
              return true
            }
          }

          return false
        }

        if (!cur.map.containsKey(c)) {
          return false
        }

        cur = cur.map[c]!!
      }

      return cur.isWord
    }

    return dfs(root, 0)
  }
}