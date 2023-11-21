package three_sum_15;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
  /*
   * Intuition
   * ----
   * We first need to have a sorted array
   * We can then pick up the numbers in order from left to right
   * This number will be called the "target"
   *
   * We then create a window starting at targetIndex + 1 up to the last number
   * If target + lo + hi = 0 then we can add the elements to our array
   *
   * But we also need to avoid storing duplicates
   * So we use a HashSet to ensure we don't store the same suite of numbers twice
   *
   * If the numbers are not equal, we have two situations
   * - The sum is < 0, then the lo is too small, we move lo to the right
   * - The sum is > 0, then the hi is too large, we move hi to the left
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();
    HashSet<String> memory = new HashSet<String>();

    for (int i = 0; i < nums.length; i++) {
      int target = nums[i];
      int lo = i + 1;
      int hi = nums.length - 1;

      while (lo < hi) {
        int sum = target + nums[lo] + nums[hi];
        if (sum == 0) {
          String s = String.valueOf(target) + nums[lo] + nums[hi];
          if (!memory.contains(s)) {
            memory.add(s);
            result.add(new ArrayList<>(Arrays.asList(target, nums[lo], nums[hi])));
          }

          lo++;
        } else if (sum < 0) {
          lo++;
        } else {
          hi--;
        }
      }
    }

    return result;
  }
}
