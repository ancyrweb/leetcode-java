package bst

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTreeTest_Insert {
  @Test
  fun test_insert_1() {
    val a = BinarySearchTree(TreeNode(10, null, null));
    val expected = BinarySearchTree(TreeNode(10, TreeNode(5, null, null), null))

    a.insert(5);

    assertTrue(a.equals(expected));
  }

  @Test
  fun test_insert_2() {
    val a = BinarySearchTree(TreeNode(10, null, null));
    val expected = BinarySearchTree(TreeNode(10, null, TreeNode(15, null, null)));

    a.insert(15);

    assertTrue(a.equals(expected));
  }
  @Test
  fun test_insert_3() {
    val a = BinarySearchTree(
      TreeNode(10,
        TreeNode(5, null, null),
        null
      )
    );

    val expected = BinarySearchTree(
      TreeNode(10,
        TreeNode(
          5,
          null,
          TreeNode(7, null, null)),
        null
      )
    )

    a.insert(7);

    assertArrayEquals(arrayListOf(5, 7, 10).toArray(), a.inOrder().toArray());
  }
}