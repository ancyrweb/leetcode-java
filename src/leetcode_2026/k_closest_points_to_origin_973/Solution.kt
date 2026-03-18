package leetcode_2026.k_closest_points_to_origin_973

import java.util.*

class Solution {
  fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> = kClosestMaxHeap(points, k)

  /**
   * MaxHeap solution
   *
   * Points are sorted from farthest to closest.
   * However, we maintain a size of `k`
   * Thus, anytime a new point is added, the farthest point is removed from the list if the list's size > k.
   * No order guarantees.
   *
   * This turns the time complexity from O(n*log(n)) to O(n*log(k)) because the size is never > k.
   */
  fun kClosestMaxHeap(points: Array<IntArray>, k: Int): Array<IntArray> {
    val q = PriorityQueue<IntArray>(compareByDescending { it[0] * it[0] + it[1] * it[1] })
    for (p in points) {
      q.offer(p)
      if (q.size > k) {
        q.poll()
      }
    }

    return q.toTypedArray()
  }

  /**
   * MinHeap solution.
   * We keep all the points stored in the MinHeap from closest to farthest.
   *
   * Each element is inserted in O(log(n)) and there are n elements
   * So insertion takes O(n*log(n)) which is the time complexity of the algorithm.
   *
   * Returns the answer in proper order.
   */
  fun kClosestMinHeap(points: Array<IntArray>, k: Int): Array<IntArray> {
    val q = PriorityQueue<IntArray>(compareBy { it[0] * it[0] + it[1] * it[1] })
    for (p in points) {
      q.offer(p)
    }

    val out = mutableListOf<IntArray>()
    for (i in 0 until k) {
      out.add(q.poll())
    }

    return out.toTypedArray()
  }

}