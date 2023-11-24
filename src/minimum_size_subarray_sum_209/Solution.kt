package minimum_size_subarray_sum_209

class Solution {
  fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE;
    var sum = 0;
    var left = 0;

    for (right in nums.indices) {
      sum += nums[right];

      while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return if (result != Int.MAX_VALUE) result else 0;
  }
}