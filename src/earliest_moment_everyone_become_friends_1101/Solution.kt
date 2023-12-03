package earliest_moment_everyone_become_friends_1101

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class Solution {
  fun earliestAcq(logs: Array<IntArray>, n: Int): Int {
    Arrays.sort(logs) { a, b -> a[0] - b[0] }

    val roots = Array<Int>(n) { it }
    val ranks = Array<Int>(n) { 1 }

    fun find(node: Int): Int {
      if (roots[node] == node) {
        return node
      }

      roots[node] = find(roots[node])
      return roots[node]
    }

    fun union(a: Int, b: Int): Int {
      val p1 = find(a)
      val p2 = find(b)

      if (p1 == p2) {
        return 0
      }

      if (ranks[p1] > ranks[p2]) {
        roots[p2] = p1
      } else if (ranks[p2] > ranks[p1]) {
        roots[p1] = p2
      } else {
        roots[p1] = p2
        ranks[p2]++
      }

      return 1
    }

    var remaining = n
    for (log in logs) {
      remaining -= union(log[1], log[2])
      if (remaining == 1) {
        return log[0]
      }
    }

    return -1
  }

  @Test
  fun test_case_1() {
    assertEquals(
      20190301,
      earliestAcq(
        arrayOf(
          intArrayOf(20190101, 0, 1),
          intArrayOf(20190104, 3, 4),
          intArrayOf(20190107, 2, 3),
          intArrayOf(20190211, 1, 5),
          intArrayOf(20190224, 2, 4),
          intArrayOf(20190301, 0, 3),
          intArrayOf(20190312, 1, 2),
          intArrayOf(20190322, 4, 5)
        ),
        6
      )
    )
  }

  @Test
  fun test_case_24() {
    assertEquals(
      2,
      earliestAcq(
        arrayOf(
          intArrayOf(9, 3, 0),
          intArrayOf(0, 2, 1),
          intArrayOf(8, 0, 1),
          intArrayOf(1, 3, 2),
          intArrayOf(2, 2, 0),
          intArrayOf(3, 3, 1),
        ),
        4
      )
    )
  }
}