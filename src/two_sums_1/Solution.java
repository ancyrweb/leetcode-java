package two_sums_1;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[]{ map.get(diff), i };
      }

      map.put(nums[i], i);
    }

    return new int[]{0, 0};
  }

  public int[] twoSum_slow(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int first = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int second = nums[j];
        if ((first + second) == target) {
          return new int[]{i, j};
        }
      }
    }

    return nums;
  }
}