package subsets_78

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Solution {
  fun subsets_one(nums: IntArray): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    val subset = mutableListOf<Int>()

    fun compute(i: Int) {
      if (i == nums.size) {
        list.add(subset.toList())
        return
      }

      subset.add(nums[i])
      compute(i + 1)
      subset.removeLast()
      compute(i + 1)
    }

    compute(0)
    return list
  }

  fun subsets(nums: IntArray): List<List<Int>> {
    val list = mutableListOf<List<Int>>()

    fun compute(num: Int) {
      for (i in 0 until list.size) {
        val sub = mutableListOf(num);
        for (j in 0 until list[i].size) {
          sub += list[i][j]
        }

        list += sub
      }
      
      list += listOf(num);
    }

    for (i in nums.size - 1 downTo 0) {
      compute(nums[i]);
    }

    list += ArrayList<Int>();
    return list
  }

  @Test
  fun test_case_1() {
    val input = intArrayOf(1, 2, 3);
    var expected = listOf(
      listOf(1, 2, 3),
      listOf(1, 2),
      listOf(1, 3),
      listOf(1),
      listOf(2, 3),
      listOf(2),
      listOf(3),
      listOf()
    );


    assertArrayEquals(
      expected.toTypedArray(),
      Solution().subsets(input).toTypedArray()
    )
  }
}