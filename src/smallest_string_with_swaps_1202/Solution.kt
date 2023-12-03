package smallest_string_with_swaps_1202

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
    val roots = Array(s.length) { it }
    val ranks = Array(s.length) { 1 }

    val out = CharArray(s.length)
    val map = HashMap<Int, MutableList<Int>>()

    fun find(x: Int): Int {
      if (x == roots[x]) {
        return x
      }

      roots[x] = find(roots[x])
      return roots[x]
    }

    fun union(a: Int, b: Int) {
      val p1 = find(a)
      val p2 = find(b)

      if (p1 == p2) {
        return
      }

      if (ranks[p1] > ranks[p2]) {
        roots[p2] = p1
      } else if (ranks[p2] > ranks[p1]) {
        roots[p1] = p2
      } else {
        roots[p1] = p2
        ranks[p2]++
      }

      return
    }

    for (pair in pairs) {
      union(pair[0], pair[1])
    }

    // The idea is to group together values that belong to the same group
    // Because all the elements in the same group are interchangeable

    for (i in s.indices) {
      val root = find(i)

      map.putIfAbsent(root, mutableListOf())
      map[root]!!.add(i)
    }

    // Then we sort each group independently and put them back in the string
    // Note : if we have only one group we can have a perfectly sorted string

    for (component in map.values) {
      val chars = mutableListOf<Char>()
      for (index in component) {
        chars.add(s[index])
      }

      chars.sort()

      for (i in 0 until component.size) {
        out[component[i]] = chars[i]
      }
    }

    return String(out)
  }

  @Test
  fun test_case_1() {
    assertEquals(
      "bacd",
      smallestStringWithSwaps(
        "dcab",
        listOf(
          listOf(0, 3),
          listOf(1, 2)
        )
      )
    )
  }
}