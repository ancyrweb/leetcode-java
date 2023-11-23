package bst

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTreeTest_ArrayConstruction {
  @Test
  fun test_1() {
    val a = BinarySearchTree(arrayOf(8, 3, 1, 6, 4, 7, 10, 14, 13));
    val expected = arrayOf(1, 3, 4, 6, 7, 8, 10, 13, 14);

    assertArrayEquals(expected, a.inOrder().toArray());
  }
}