package graph_valid_tree_261

class Solution {
  fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    if (n == 1) {
      return true
    }

    val visited = HashSet<Int>()
    val childrens = HashSet<Int>()
    val adj = HashMap<Int, MutableList<Int>>()

    for (i in 0 until n) {
      adj[i] = mutableListOf<Int>()
    }

    for (edge in edges) {
      adj[edge[0]]!!.add(edge[1])
      adj[edge[1]]!!.add(edge[0])
    }

    var parent = -1
    for (i in 0 until n) {
      if (!childrens.contains(i)) {
        if (parent != -1) {
          return false
        }

        parent = i
      }
    }

    if (parent == -1) {
      return false
    }

    val q = mutableListOf<Int>(parent)
    var prev: Int? = null
    while (q.isNotEmpty()) {
      for (i in 0 until q.size) {
        val next = q.removeFirst()
        if (visited.contains(next)) {
          return false
        }

        visited.add(next)
        for (a in adj[next]!!) {
          if (a != next) {
            q.add(a)
          }
        }
      }
    }

    return visited.size == n
  }
}