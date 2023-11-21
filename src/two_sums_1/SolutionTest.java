package two_sums_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
  @Test
  void testCase1() {
    Solution solution = new Solution();
    int[] input = new int[]{ 2, 7, 11, 15 };
    int target = 9;
    int[] output = new int[]{0, 1};

    int[] result = solution.twoSum(input, target);
    assertArrayEquals(result, output);
  }
  @Test
  void testCase2() {
    Solution solution = new Solution();
    int[] input = new int[]{ 3, 2, 4 };
    int target = 6;
    int[] output = new int[]{1, 2};

    int[] result = solution.twoSum(input, target);
    assertArrayEquals(result, output);
  }
  @Test
  void testCase3() {
    Solution solution = new Solution();
    int[] input = new int[]{ 3, 3 };
    int target = 6;
    int[] output = new int[]{0, 1};

    int[] result = solution.twoSum(input, target);
    assertArrayEquals(result, output);
  }
}
