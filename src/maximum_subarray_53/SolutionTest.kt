package maximum_subarray_53

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionTest {
  @Test
  fun test_case_1() {
    val input = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4);
    val expected = 6;

    val solution = Solution();
    val result = solution.maxSubArray(input);
    assertEquals(expected, result);
  }
  @Test
  fun test_case_2() {
    val input = intArrayOf(1);
    val expected = 1;

    val solution = Solution();
    val result = solution.maxSubArray(input);
    assertEquals(expected, result);
  }
  @Test
  fun test_case_3() {
    val input = intArrayOf(5, 4, -1, 7, 8);
    val expected = 23;

    val solution = Solution();
    val result = solution.maxSubArray(input);
    assertEquals(expected, result);
  }
  @Test
  fun test_case_4() {
    val input = intArrayOf(-1);
    val expected = -1;

    val solution = Solution();
    val result = solution.maxSubArray(input);
    assertEquals(expected, result);
  }
  @Test
  fun test_case_5() {
    val input = intArrayOf(-2, -1);
    val expected = -1;

    val solution = Solution();
    val result = solution.maxSubArray(input);
    assertEquals(expected, result);
  }
}