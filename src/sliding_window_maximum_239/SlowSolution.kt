package sliding_window_maximum_239

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SlowSolution {
  class MaxIndex(var index: Int, var value: Int) {
    override fun toString(): String {
      return "$index : $value"
    }
  }

  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val array = ArrayList<Int>()
    var max = MaxIndex(-1, Int.MIN_VALUE)

    for (i in 0 until k) {
      if (nums[i] > max.value) {
        max.index = i
        max.value = nums[i]
      }
    }

    array.add(max.value)


    for (i in k until nums.size) {
      val left = (i - (k - 1))
      if (left > max.index) {
        max.value = Int.MIN_VALUE
        max.index = -1
        val right = left + k - 1

        for (j in left until right) {
          if (nums[j] > max.value) {
            max.index = j
            max.value = nums[j]
          }
        }
      }

      if (nums[i] > max.value) {
        max.index = i
        max.value = nums[i]
      }

      array.add(max.value)
    }

    return array.toIntArray()
  }

  @Test
  fun test_case_1() {
    assertArrayEquals(
      intArrayOf(3, 3, 5, 5, 6, 7),
      SlowSolution().maxSlidingWindow(
        intArrayOf(1, 3, -1, -3, 5, 3, 6, 7),
        3
      )
    )
  }

  @Test
  fun test_case_2() {
    assertArrayEquals(
      intArrayOf(1),
      SlowSolution().maxSlidingWindow(
        intArrayOf(1),
        1
      )
    )
  }

  @Test
  fun test_case_3() {
    assertArrayEquals(
      intArrayOf(1, -1),
      SlowSolution().maxSlidingWindow(
        intArrayOf(1, -1),
        1
      )
    )
  }

  @Test
  fun test_case_4() {
    assertArrayEquals(
      intArrayOf(3, 3, 2, 5),
      SlowSolution().maxSlidingWindow(
        intArrayOf(1, 3, 1, 2, 0, 5),
        3
      )
    )
  }
}
