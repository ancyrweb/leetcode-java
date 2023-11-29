package permutations_46

class Solution {
  fun permute(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val tracker = ArrayDeque<Int>()

    fun dfs() {
      if (tracker.size == nums.size) {
        result.add(tracker.toList())
        return
      }

      for (num in nums) {
        if (num in tracker) {
          continue
        }

        tracker.addLast(num)
        dfs()
        tracker.removeLast()
      }
    }

    dfs()
    return result
  }
}