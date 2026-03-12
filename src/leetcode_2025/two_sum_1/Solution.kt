package leetcode_2025.two_sum_1

class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
      val complement = target - nums[i]
      if (map.containsKey(complement) && map[complement] != i) {
        return intArrayOf(map[complement]!!, i)
      }

      map[nums[i]] = i
    }

    return intArrayOf()
  }

  fun twoSum_doubleLoop(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
      map[nums[i]] = i
    }

    for (i in nums.indices) {
      val complement = target - nums[i]
      if (map.containsKey(complement) && map[complement] != i) {
        return intArrayOf(i, map[complement]!!)
      }
    }

    return intArrayOf()
  }

}