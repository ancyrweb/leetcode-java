package leetcode_2026.group_anagram_49

class Solution {
  fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val maps = mutableMapOf<String, MutableList<String>>()
    for (s in strs) {
      val key = s.toCharArray().sorted().toString();
      if (maps.containsKey(key)) {
        maps[key]?.add(s)
      } else {
        maps[key] = mutableListOf(s)
      }
    }

    return maps.values.toList()
  }
}