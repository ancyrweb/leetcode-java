package largest_odd_number_in_string_1903

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun largestOddNumber(num: String): String {
    var i = num.length - 1

    while (i >= 0 && num[i].code % 2 == 0) {
      i--
    }

    return num.substring(0, i + 1)
  }

  @Test
  fun test_case_1() {
    assertEquals("5", largestOddNumber("52"))
  }

  @Test
  fun test_case_2() {
    assertEquals("", largestOddNumber("4206"))
  }

  @Test
  fun test_case_3() {
    assertEquals("35427", largestOddNumber("35427"))
  }
}