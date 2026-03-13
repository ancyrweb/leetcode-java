package leetcode_2026.group_anagram_49

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
  fun run(strs: Array<String>): List<List<String>> {
    val solution = Solution()
    return solution.groupAnagrams(strs)
  }

  @Test
  fun case1() {
    assertEquals(
      listOf(
        listOf("eat", "tea", "ate"),
        listOf("tan", "nat"),
        listOf("bat"),
      ),
      run(
        arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
      ),
    )
  }
}