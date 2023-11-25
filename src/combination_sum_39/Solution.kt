package combination_sum_39

class Solution {
  fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val output = mutableListOf<List<Int>>();
    val subset = mutableListOf<Int>();

    fun dfs(target: Int) {
      if (target == 0) {
        output += subset.toList();
        return;
      }

      if (target < 0) {
        return;
      }

      for (i in candidates) {
        if (subset.size > 0 && subset.last() > i) {
          continue;
        }

        subset += i;
        dfs(target - i);
        subset.removeLast();
      }
    }

    dfs(target);

    return output;
  }
}

fun main() {
  val res = Solution().combinationSum(intArrayOf(2, 3, 5), 8);
  for (i in res) {
    println(i);
  }
}