package middle_of_linked_list_876

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  @Test
  fun test_case_1() {
    val node1 = ListNode(1)
    val node2 = ListNode(2);
    val node3 = ListNode(3);
    val node4 = ListNode(4);
    val node5 = ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    val expected = node3;

    assertEquals(expected, Solution().middleNode(node1))
  }

  @Test
  fun test_case_2() {
    val node1 = ListNode(1)
    val node2 = ListNode(2);
    val node3 = ListNode(3);
    val node4 = ListNode(4);
    val node5 = ListNode(5);
    val node6 = ListNode(6);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    val expected = node4;

    assertEquals(expected, Solution().middleNode(node1))
  }
}