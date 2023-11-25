package binary_tree_level_order_102

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionTest {
  @Test
  fun test_case_1() {
    val input = TreeNode(
      3,
      TreeNode(9, null, null),
      TreeNode(20,
        TreeNode(15, null, null),
        TreeNode(7, null, null)
      )
    )

    val expected = listOf(
      listOf(3),
      listOf(9, 20),
      listOf(15, 7)
    )

    val solution = Solution();

    assertArrayEquals(
      expected.toTypedArray(),
      solution.levelOrder(input).toTypedArray()
    )
  }

  @Test
  fun test_case_2() {
    val input = TreeNode(
      1,
     null,
    null
    )

    val expected = listOf(
      listOf(1),
    )

    val solution = Solution();

    assertArrayEquals(
      expected.toTypedArray(),
      solution.levelOrder(input).toTypedArray()
    )
  }

  @Test
  fun test_case_3() {
    val input = null
    val expected = ArrayList<Int>();

    val solution = Solution();

    assertArrayEquals(
      expected.toTypedArray(),
      solution.levelOrder(input).toTypedArray()
    )
  }
}