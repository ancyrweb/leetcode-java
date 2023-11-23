package two_sum_III_170

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class SolutionTest {
  @Test
  fun test_case_1() {
    val solution = TwoSum();
    solution.add(1);
    solution.add(3);
    solution.add(5);

    assertEquals(true, solution.find(4))
    assertEquals(false, solution.find(7))
  }
  @Test
  fun test_case_13() {
    val solution = TwoSum();
    solution.add(0);
    solution.add(0);

    assertEquals(true, solution.find(0))
  }
}