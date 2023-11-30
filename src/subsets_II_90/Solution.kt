package subsets_II_90

class Solution {
  fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = ArrayList<List<Int>>()
    val subset = ArrayList<Int>()

    fun backtrack(i: Int) {
      var j = i

      if (j == nums.size) {
        result.add(subset.toList())
        return
      }

      subset.add(nums[j])
      backtrack(i + 1)
      subset.remove(nums[j])

      while (j + 1 < nums.size && nums[j] == nums[j + 1]) {
        j++
      }

      backtrack(j + 1)
    }

    backtrack(0)
    return result
  }
}