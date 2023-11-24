package subarrays_1343

class Solution {
  fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    var count = 0;
    var accumulator = 0;
    var left = 0;

    for (right in 0 until arr.size) {
      accumulator += arr[right];
      if (right - left + 1 >= k) {
        if (accumulator / k >= threshold) {
          count++;
        }

        accumulator -= arr[left];
        left++;
      }
    }

    return count;
  }
}