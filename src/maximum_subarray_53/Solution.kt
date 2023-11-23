package maximum_subarray_53

class Solution {
  fun maxSubArray(nums: IntArray): Int {
    var max = nums[0];
    var curr = 0;

    for (i in 0 until nums.size) {
      curr = Math.max(curr, 0);
      curr += nums[i];
      max = Math.max(max, curr);
    }

    return max;
  }
}