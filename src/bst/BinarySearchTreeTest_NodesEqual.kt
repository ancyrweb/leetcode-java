package bst

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTreeTest_NodesEqual {
  @Test
  fun test_nodesEquals_1() {
    val a = BinarySearchTree(TreeNode(1, null, null));
    val b = BinarySearchTree(TreeNode(1, null, null));

    assertTrue(a.equals(b));
  }
  @Test
  fun test_nodesEquals_2() {
    val a = BinarySearchTree(
      TreeNode(1, null, null));
    val b = BinarySearchTree(
      TreeNode(2, null, null)
    );

    assertFalse(a.equals(b));
  }

  @Test
  fun test_nodesEquals_3() {
    val a = BinarySearchTree(
      TreeNode(3, TreeNode(2, null, null), null));
    val b = BinarySearchTree(
      TreeNode(3, null, null)
    );

    assertFalse(a.equals(b));
  }
  @Test
  fun test_nodesEquals_4() {
    val a = BinarySearchTree(
      TreeNode(3, TreeNode(2, null, null), null));
    val b = BinarySearchTree(
      TreeNode(3, TreeNode(2, null, null), null)
    );

    assertTrue(a.equals(b));
  }

  @Test
  fun test_nodesEquals_5() {
    val a = BinarySearchTree(
      TreeNode(3, null, TreeNode(4, null, null)));
    val b = BinarySearchTree(
      TreeNode(3, null, null)
    );

    assertFalse(a.equals(b));
  }
  @Test
  fun test_nodesEquals_6() {
    val a = BinarySearchTree(
      TreeNode(3, null, TreeNode(4, null, null)));
    val b = BinarySearchTree(
      TreeNode(3, null, TreeNode(4, null, null))
    );

    assertTrue(a.equals(b));
  }
  @Test
  fun test_nodesEquals_7() {
    val a = BinarySearchTree(
      TreeNode(3, null, TreeNode(4, null, null)));
    val b = BinarySearchTree(
      TreeNode(3, TreeNode(4, null, null), null)
    );

    assertFalse(a.equals(b));
  }
}