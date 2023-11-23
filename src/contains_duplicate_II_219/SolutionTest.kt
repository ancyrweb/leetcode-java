package contains_duplicate_II_219

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionTest {
  @Test
  fun test_case_1() {
    val input = intArrayOf(1,2,3,1);
    val k = 3;
    val expected = true;

    val solution = Solution();
    assertEquals(expected, solution.containsNearbyDuplicate(input, k));
  }

  @Test
  fun test_case_2() {
    val input = intArrayOf(1,0, 1, 1);
    val k = 1;
    val expected = true;

    val solution = Solution();
    assertEquals(expected, solution.containsNearbyDuplicate(input, k));
  }
  @Test
  fun test_case_3() {
    val input = intArrayOf(1,2,3,1, 2, 3);
    val k = 2;
    val expected = false;

    val solution = Solution();
    assertEquals(expected, solution.containsNearbyDuplicate(input, k));
  }
}