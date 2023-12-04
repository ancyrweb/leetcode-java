package largest_good_integer_2264

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun largestGoodInteger(num: String): String {
    var count = 1
    var curr = 1
    var m = 0

    while (curr < num.length) {
      if (num[curr] == num[curr - 1]) {
        count++
      } else {
        count = 1
      }

      if (count == 3) {
        m = Math.max(m, num[curr].code)
      }

      curr++
    }

    if (m == 0) {
      return ""
    }

    val c = m.toChar()
    return "" + c + c + c
  }

  @Test
  fun test_case_1() {
    assertEquals(
      "777",
      largestGoodInteger("6777133339")
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      "000",
      largestGoodInteger("2300019")
    )
  }

  @Test
  fun test_case_3() {
    assertEquals(
      "",
      largestGoodInteger("42352338")
    )
  }

  @Test
  fun test_case_61() {
    assertEquals(
      "222",
      largestGoodInteger("222")
    )
  }
}