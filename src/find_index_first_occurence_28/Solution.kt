package find_index_first_occurence_28

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun strStr(haystack: String, needle: String): Int {
    if (needle.length > haystack.length) {
      return -1
    }

    for (left in haystack.indices) {
      if (haystack[left] == needle[0]) {
        var i = 0
        while (
          i < needle.length &&
          left + i < haystack.length &&
          haystack[left + i] == needle[i]
        ) {
          i++
        }

        if (i == needle.length) {
          return left
        }

      }
    }

    return -1
  }

  @Test
  fun case1() {
    assertEquals(
      0,
      strStr("sadbutsad", "sad")
    )
  }

  @Test
  fun case2() {
    assertEquals(
      -1,
      strStr("leetcode", "leeto")
    )
  }

  @Test
  fun case9() {
    assertEquals(
      -1,
      strStr("aaa", "aaaa")
    )
  }

  @Test
  fun case15() {
    assertEquals(
      -1,
      strStr("mississippi", "issipi")
    )
  }

  @Test
  fun case75() {
    assertEquals(
      4,
      strStr("mississippi", "issip")
    )
  }


  @Test
  fun case_custom_1() {
    assertEquals(
      -1,
      strStr("app", "apple")
    )
  }
}