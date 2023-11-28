package sliding_window_maximum_239

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Solution {

  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    // Setup a monotonically decreasing queue
    // Which means that each element i is always greater than the elements on the right
    val q = ArrayDeque<Int>()
    val result = ArrayList<Int>()

    for (i in 0 until nums.size) {
      // If we're out of bound, we remove leftmost elements
      while (q.isNotEmpty() && q.first() < i - k + 1) {
        q.removeFirst()
      }

      // Then, we maintain the decreasing order
      // To do so, we remove rightmost elements as long as they're smaller
      while (q.isNotEmpty() && nums[q.last()] < nums[i]) {
        q.removeLast()
      }

      // We can add element knowing that
      // - Out of bounds element have been popped out
      // - The order of the queue has been maintained
      q.add(i)

      // We can start adding elements to the result only after
      // We visited the first `k` elements
      if (i >= k - 1) {
        result.add(nums[q.first()])
      }
    }

    return result.toIntArray()
  }

  @Test
  fun test_case_1() {
    assertArrayEquals(
      intArrayOf(3, 3, 5, 5, 6, 7),
      Solution().maxSlidingWindow(
        intArrayOf(1, 3, -1, -3, 5, 3, 6, 7),
        3
      )
    )
  }

  @Test
  fun test_case_2() {
    assertArrayEquals(
      intArrayOf(1),
      Solution().maxSlidingWindow(
        intArrayOf(1),
        1
      )
    )
  }

  @Test
  fun test_case_3() {
    assertArrayEquals(
      intArrayOf(1, -1),
      Solution().maxSlidingWindow(
        intArrayOf(1, -1),
        1
      )
    )
  }

  @Test
  fun test_case_4() {
    assertArrayEquals(
      intArrayOf(3, 3, 2, 5),
      Solution().maxSlidingWindow(
        intArrayOf(1, 3, 1, 2, 0, 5),
        3
      )
    )
  }
}
