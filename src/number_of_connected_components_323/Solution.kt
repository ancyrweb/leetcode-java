package number_of_connected_components_323

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun countComponents(n: Int, edges: Array<IntArray>): Int {
    val parents = HashMap<Int, Int>()
    val ranks = HashMap<Int, Int>()

    for (i in 0 until n) {
      parents[i] = i
      ranks[i] = 0
    }

    fun find(node: Int): Int {
      var p = parents[node]!!
      while (p != parents[p]) {
        p = parents[p]!!
      }

      return p
    }

    fun union(n1: Int, n2: Int): Int {
      val p1 = find(n1)
      val p2 = find(n2)

      if (p1 == p2) {
        return 0
      }

      if (ranks[p1]!! > ranks[p2]!!) {
        parents[p2] = p1
      } else if (ranks[p2]!! > ranks[p1]!!) {
        parents[p1] = p2
      } else {
        parents[p1] = p2
        ranks[p2] = ranks[p2]!! + 1
      }

      return 1
    }

    var res = n
    for (edge in edges) {
      res -= union(edge[0], edge[1])
    }


    return res
  }

  @Test
  fun test_case_1() {
    assertEquals(
      2,
      countComponents(
        5,
        arrayOf(
          intArrayOf(0, 1),
          intArrayOf(1, 2),
          intArrayOf(3, 4),
        )
      )
    )
  }

  @Test
  fun test_case_30() {
    assertEquals(
      1,
      countComponents(
        4,
        arrayOf(
          intArrayOf(0, 1),
          intArrayOf(2, 3),
          intArrayOf(1, 2),
        )
      )
    )
  }
}