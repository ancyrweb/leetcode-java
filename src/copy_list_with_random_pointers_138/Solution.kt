package copy_list_with_random_pointers_138


class Node(var `val`: Int) {
  var next: Node? = null
  var random: Node? = null
}


class Solution {
  fun copyRandomList(node: Node?): Node? {
    val map = HashMap<Node, Node>()

    var cur = node
    while (cur != null) {
      map[cur] = Node(cur.`val`)
      cur = cur.next
    }

    cur = node
    while (cur != null) {
      val newNode = map[cur]!!
      newNode.next = map[cur.next]
      newNode.random = map[cur.random]
      cur = cur.next
    }

    return map[node]
  }
}