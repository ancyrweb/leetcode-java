package maximum_twin_sum_2130

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}


class Solution {
  fun pairSum(head: ListNode?): Int {
    var slow = head;
    var fast = head?.next;
    val arr = ArrayList<Int>();

    while (fast != null) {
      arr.add(slow!!.`val`);

      slow = slow!!.next;
      fast = fast?.next?.next;
    }

    var largest = Int.MIN_VALUE;

    while (slow != null) {
      val sum = slow.`val` + arr.removeLast();
      largest = Math.max(largest, sum);
      slow = slow.next;
    }

    return largest;
  }

  @Test
  fun test_case_1() {
    val node1 = ListNode(5)
    val node2 = ListNode(4);
    val node3 = ListNode(2);
    val node4 = ListNode(1);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    val expected = 6;

    assertEquals(expected, Solution().pairSum(node1));
  }

  @Test
  fun test_case_2() {
    val node1 = ListNode(4)
    val node2 = ListNode(2);
    val node3 = ListNode(2);
    val node4 = ListNode(3);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    val expected = 7;

    assertEquals(expected, Solution().pairSum(node1));
  }

  @Test
  fun test_case_3() {
    val node1 = ListNode(1)
    val node2 = ListNode(100000);

    node1.next = node2;

    val expected = 100001;

    assertEquals(expected, Solution().pairSum(node1));
  }
}