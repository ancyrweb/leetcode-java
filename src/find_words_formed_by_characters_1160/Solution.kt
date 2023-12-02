package find_words_formed_by_characters_1160

class TrieNode {
  public val map = HashMap<Char, TrieNode>()
  public var size: Int? = null
}

class Solution {
  fun countCharacters(words: Array<String>, chars: String): Int {
    fun dfs(word: String): Int {
      val map = HashMap<Char, Int>()
      var size = 0

      for (c in word) {
        if (map.containsKey(c).not()) {
          map[c] = 0
        }

        map[c] = map[c]!! + 1
        size++
      }

      for (c in chars) {
        if (c in map && map[c]!! > 0) {
          map[c] = map[c]!! - 1
          size--
        }

        if (size == 0) {
          return word.length
        }
      }

      return if (size == 0) word.length else 0
    }

    var size = 0
    for (word in words) {
      size += dfs(word)
    }

    return size
  }
}