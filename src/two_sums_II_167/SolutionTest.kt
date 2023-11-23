import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

import two_sums_II_167.Solution

class SolutionTest {
  @Test
  fun test_case_1() {
    val input = intArrayOf(2, 7, 11, 15);
    val target = 9;
    val expected = intArrayOf(1, 2)

    val solution = Solution();
    val result = solution.twoSum(input, target);

    assertArrayEquals(expected, result);
  }
  @Test
  fun test_case_2() {
    val input = intArrayOf(2, 3, 4);
    val target = 6;
    val expected = intArrayOf(1, 3)

    val solution = Solution();
    val result = solution.twoSum(input, target);
    
    assertArrayEquals(expected, result);
  }
  @Test
  fun test_case_3() {
    val input = intArrayOf(-1, 0);
    val target = -1;
    val expected = intArrayOf(1, 2)

    val solution = Solution();
    val result = solution.twoSum(input, target);
    
    assertArrayEquals(expected, result);
  }
}