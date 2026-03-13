package leetcode_2026.contains_duplicate_217

class Solution {
  fun containsDuplicate(nums: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
      if (map.containsKey(num)) {
        return true
      }

      map[num] = 1
    }

    return false
  }

  fun containsDuplicate_sorting(nums: IntArray): Boolean {
    nums.sort()
    for (i in 1 until nums.size) {
      if (nums[i] == nums[i - 1]) {
        return true
      }
    }

    return false
  }

  fun containsDuplicate_set(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums) {
      if (!set.add(num)) {
        return true
      }
    }

    return false
  }
}