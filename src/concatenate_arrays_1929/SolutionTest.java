package concatenate_arrays_1929;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
  @Test
  void test_1234() {
    Solution solution = new Solution();
    int[] initial = new int[]{1, 2, 3, 4};
    int[] expected = new int[]{1, 2, 3, 4, 1, 2, 3, 4};

    int[] result = solution.getConcatenation(initial);

    assertArrayEquals(result, expected);
  }

  @Test
  void test_121() {
    Solution solution = new Solution();
    int[] initial = new int[]{1, 2, 1};
    int[] expected = new int[]{1, 2, 1, 1, 2, 1};

    int[] result = solution.getConcatenation(initial);

    assertArrayEquals(result, expected);
  }
}