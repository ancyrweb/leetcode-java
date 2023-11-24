package minimum_size_subarray_sum_209

class Solution {
  fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var sum = 0;
    var left = 0;
    var result = 0;

    for (right in nums.indices) {
      sum += nums[right];

      if (sum < target) {
        continue;
      }

      if (result == 0) {
        result = right - left + 1;
      }

      while (sum > target) {
        sum -= nums[left];
        left++;

        if (sum >= target) {
          result = Math.min(result, right - left + 1);
        }
      }
    }

    return result;
  }
}