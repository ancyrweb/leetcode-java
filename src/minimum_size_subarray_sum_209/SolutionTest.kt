package minimum_size_subarray_sum_209

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class SolutionTest {
  @Test
  fun test_case_1() {
    val input = intArrayOf(2, 3, 1, 2, 4, 3);
    val target = 7;
    val expected = 2;

    val solution = Solution();
    assertEquals(expected, solution.minSubArrayLen(target, input));
  }

  @Test
  fun test_case_2() {
    val input = intArrayOf(1, 4, 4);
    val target = 4;
    val expected = 1;

    val solution = Solution();
    assertEquals(expected, solution.minSubArrayLen(target, input));
  }
  @Test
  fun test_case_3() {
    val input = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1);
    val target = 11;
    val expected = 0;

    val solution = Solution();
    assertEquals(expected, solution.minSubArrayLen(target, input));
  }

  @Test
  fun test_case_8() {
    val input = intArrayOf(1, 2, 3, 4, 5);
    val target = 11;
    val expected = 3;

    val solution = Solution();
    assertEquals(expected, solution.minSubArrayLen(target, input));
  }

}