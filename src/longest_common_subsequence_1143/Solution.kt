package longest_common_subsequence_1143

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Solution {
  fun longestCommonSubsequence(text1: String, text2: String): Int {
    val ROWS = text1.length
    val COLS = text2.length

    val cells = Array(ROWS + 1) { IntArray(COLS + 1) }

    for (i in text1.length - 1 downTo 0) {
      for (j in text2.length - 1 downTo 0) {
        if (text1[i] == text2[j]) {
          cells[i][j] = 1 + cells[i + 1][j + 1]
        } else {
          cells[i][j] = Math.max(cells[i + 1][j], cells[i][j + 1])
        }
      }
    }

    return cells[0][0]
  }

  @Test
  fun test_case_1() {
    assertEquals(
      3,
      longestCommonSubsequence(
        "abcde",
        "ace"
      )
    )
  }

  @Test
  fun test_case_2() {
    assertEquals(
      3,
      longestCommonSubsequence(
        "abc",
        "abc"
      )
    )
  }

  @Test
  fun test_case_3() {
    assertEquals(
      0,
      longestCommonSubsequence(
        "abc",
        "def"
      )
    )
  }

  @Test
  fun test_case_5() {
    assertEquals(
      1,
      longestCommonSubsequence(
        "bl",
        "yby"
      )
    )
  }

  @Test
  fun test_case_7() {
    assertEquals(
      1,
      longestCommonSubsequence(
        "psnw",
        "vozsh"
      )
    )
  }

  @Test
  fun test_case_8() {
    assertEquals(
      2,
      longestCommonSubsequence(
        "ezupkr",
        "ubmrapg"
      )
    )
  }

  @Test
  fun test_case_16() {
    assertEquals(
      1,
      longestCommonSubsequence(
        "bsbininm",
        "jmjkbkjkv"
      )
    )
  }
}