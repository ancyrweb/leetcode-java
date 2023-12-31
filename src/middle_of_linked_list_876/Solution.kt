package middle_of_linked_list_876

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

class Solution {
  fun middleNode(head: ListNode?): ListNode? {
    var fast = head;
    var slow = head;

    while (fast != null && fast.next !== null) {
      slow = slow!!.next;
      fast = fast.next!!.next;
    }

    return slow;
  }
}