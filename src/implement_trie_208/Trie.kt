package implement_trie_208

class Node {
  public val map = HashMap<Char, Node>()
  public var isWord = false
}

class Trie {
  private val root = Node()

  fun insert(word: String) {
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
    var cur: Node = root

    for (c in word) {
      if (!cur.map.containsKey(c)) {
        return false
      }
      cur = cur.map[c]!!
    }

    return cur.isWord
  }

  fun startsWith(prefix: String): Boolean {
    var cur: Node = root

    for (c in prefix) {
      if (!cur.map.containsKey(c)) {
        return false
      }
      cur = cur.map[c]!!
    }

    return true
  }
}