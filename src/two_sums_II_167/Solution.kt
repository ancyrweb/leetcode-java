package two_sums_II_167

class Solution {
  fun twoSum(numbers: IntArray, target: Int): IntArray {
    var lo = 0;
    var hi = numbers.size - 1;

    while (lo < hi) {
      val sum = numbers[lo] + numbers[hi];

      if (sum < target) {
        lo++;
      } else if (sum > target) {
        hi--;
      } else {
        return intArrayOf(lo + 1, hi + 1);
      }
    }

    return intArrayOf();
  }
}