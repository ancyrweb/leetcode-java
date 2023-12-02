package number_of_provinces_547

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun findCircleNum(isConnected: Array<IntArray>): Int {
    val n = isConnected.size
    val parents = Array<Int>(n) { it }
    val ranks = Array<Int>(n) { 0 }

    fun find(node: Int): Int {
      var curr = parents[node]
      while (curr != parents[curr]) {
        curr = parents[curr]
      }

      return curr
    }

    fun union(a: Int, b: Int): Int {
      val p1 = find(a)
      val p2 = find(b)

      if (p1 == p2) {
        return 0
      }

      if (ranks[p1] > ranks[p2]) {
        parents[p2] = p1
      } else if (ranks[p2] > ranks[p1]) {
        parents[p1] = p2
      } else {
        parents[p1] = p2
        ranks[p2]++
      }

      return 1
    }

    // Initially we have as much provinces as they are nodes
    var out = n

    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i == j) {
          continue
        }

        if (isConnected[i][j] == 1) {
          // If union returns 1, it means we united two nodes
          // Which means they are connected and form one province
          out -= union(i, j)
        }
      }
    }

    return out
  }

  @Test
  fun test_case_1() {
    assertEquals(
      2,
      findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      3,
      findCircleNum(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1)))
    )
  }

  @Test
  fun test_case_3() {
    assertEquals(
      1,
      findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)))
    )
  }
}