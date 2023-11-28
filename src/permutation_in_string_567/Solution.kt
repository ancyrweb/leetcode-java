package permutation_in_string_567

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Solution {
  fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) {
      return false
    }

    val s1Freq = IntArray(26)
    val s2Freq = IntArray(26)

    for (i in s1.indices) {
      s1Freq[s1[i].code - 97]++
      s2Freq[s2[i].code - 97]++
    }

    for (i in 0 until s2.length - s1.length) {
      if (s1Freq.contentEquals(s2Freq)) {
        return true
      }

      s2Freq[s2[i].code - 97]--
      s2Freq[s2[i + s1.length].code - 97]++
    }

    return s1Freq.contentEquals(s2Freq)
  }

  @Test
  fun test_case_1() {
    assertTrue(checkInclusion("ab", "eidbaooo"))
  }

  @Test
  fun test_case_2() {
    assertFalse(checkInclusion("ab", "eidboaoo"))
  }

  @Test
  fun test_case_3() {
    assertTrue(checkInclusion("adc", "dcda"))
  }
}