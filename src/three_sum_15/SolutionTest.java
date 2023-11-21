package three_sum_15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
  @Test
  void testCase1() {
    Solution solution = new Solution();
    int[] input = new int[]{ -1, 0, 1, 2, -1, -4};
    List<List<Integer>> expected = new ArrayList<List<Integer>>(
        Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(-1, -1, 2)),
            new ArrayList<Integer>(Arrays.asList(-1, 0, 1))
        )
    );

    List<List<Integer>> output = solution.threeSum(input);
    assertArrayEquals(expected.toArray(), output.toArray());
  }

  @Test
  void testCase2() {
    Solution solution = new Solution();
    int[] input = new int[]{ 0, 1, 1 };
    List<List<Integer>> expected = new ArrayList<List<Integer>>(
        Arrays.asList(

        )
    );

    List<List<Integer>> output = solution.threeSum(input);
    assertArrayEquals(expected.toArray(), output.toArray());
  }

  @Test
  void testCase3() {
    Solution solution = new Solution();
    int[] input = new int[]{ 0, 0, 0 };
    List<List<Integer>> expected = new ArrayList<List<Integer>>(
        Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(0, 0, 0))

        )
    );

    List<List<Integer>> output = solution.threeSum(input);
    assertArrayEquals(expected.toArray(), output.toArray());
  }

}
