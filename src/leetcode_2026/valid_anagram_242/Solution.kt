package leetcode_2026.valid_anagram_242

class Solution {
  fun isAnagram(s: String, t: String): Boolean {
    val sChars = s.toCharArray().also { it.sort() }
    val tChars = t.toCharArray().also { it.sort() }
    return sChars.contentEquals(tChars)
  }

  fun isAnagram_maps(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }

    val aMap = mutableMapOf<Char, Int>()
    for (c in s) {
      aMap[c] = aMap.getOrDefault(c, 0) + 1
    }

    val bMap = mutableMapOf<Char, Int>()
    for (c in t) {
      bMap[c] = bMap.getOrDefault(c, 0) + 1
    }

    for (c in aMap.keys) {
      if (aMap[c] != bMap[c]) {
        return false
      }
    }

    return true
  }

  fun isAnagram_sort(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }

    val sChars = s.toCharArray().also { it.sort() }
    val tChars = t.toCharArray().also { it.sort() }
    return sChars.contentEquals(tChars)
  }
}