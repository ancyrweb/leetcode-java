package container_with_most_water_11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
  @Test
  void testCase1() {
    Solution solution = new Solution();
    int[] input = new int[]{ 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int output = 49;

    int result = solution.maxArea(input);
    assertEquals(result, output);
  }

  @Test
  void testCase2() {
    Solution solution = new Solution();
    int[] input = new int[]{ 1, 1 };
    int output = 1;

    int result = solution.maxArea(input);
    assertEquals(result, output);
  }
}
