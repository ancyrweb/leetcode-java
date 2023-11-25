package binary_tree_right_side_view_199

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
  @Test
  fun test_case_1() {
    val input = TreeNode(
      1,
      TreeNode(2, null, null),
      TreeNode(3,
        TreeNode(5, null, null),
        TreeNode(4, null, null)
      )
    )

    val expected = listOf(1, 3, 4)

    val solution = Solution();

    Assertions.assertArrayEquals(
      expected.toTypedArray(),
      solution.rightSideView(input).toTypedArray()
    )
  }

  @Test
  fun test_case_2() {
    val input = TreeNode(
      1,
      null,
      TreeNode(3, null, null)
    )

    val expected = listOf(1, 3)

    val solution = Solution();

    Assertions.assertArrayEquals(
      expected.toTypedArray(),
      solution.rightSideView(input).toTypedArray()
    )
  }

  @Test
  fun test_case_3() {
    val input = null
    val expected = ArrayList<Int>();

    val solution = Solution();

    Assertions.assertArrayEquals(
      expected.toTypedArray(),
      solution.rightSideView(input).toTypedArray()
    )
  }
}