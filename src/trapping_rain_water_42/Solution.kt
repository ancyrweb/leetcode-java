package trapping_rain_water_42

class Solution {
  fun trap(height: IntArray): Int {
    var left = 0;
    var right = height.size - 1
    var maxLeft = height[left]
    var maxRight = height[right]
    var result = 0

    while (left < right) {
      if (maxLeft < maxRight) {
        left++
        maxLeft = Math.max(maxLeft, height[left])
        result += Math.max(0, maxLeft - height[left])
      } else {
        right--
        maxRight = Math.max(maxRight, height[right])
        result += Math.max(0, maxRight - height[right])
      }
    }

    return result
  }

  fun trap_extra_space(height: IntArray): Int {
    var result = 0
    val maxRight = Array<Int>(height.size) { it -> 0 }
    var curMax = 0

    for (i in height.size - 1 downTo 0) {
      maxRight[i] = curMax
      curMax = Math.max(curMax, height[i])
    }

    curMax = 0

    for (i in 0 until height.size) {
      result += Math.max(0, Math.min(curMax, maxRight[i]) - height[i])
      curMax = Math.max(curMax, height[i])
    }

    return result
  }
}

fun main() {
  println(
    "result : ${
      Solution().trap(
        intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
      )
    }"
  )

  println("----")

  println(
    "result : ${
      Solution().trap(
        intArrayOf(4, 2, 0, 3, 2, 5)
      )
    }"
  )
}