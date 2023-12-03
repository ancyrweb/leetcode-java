package number_of_1_bits_191

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  // you need treat n as an unsigned value
  fun hammingWeight(n: Int): Int {
    var x = n
    var count = 0

    while (x != 0) {
      if (x and 1 == 1) {
        count++
      }

      x = x ushr 1
    }

    return count
  }

  @Test
  fun test_case_1() {
    assertEquals(
      3,
      hammingWeight(521)
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      1,
      hammingWeight(2097152)
    )
  }

}