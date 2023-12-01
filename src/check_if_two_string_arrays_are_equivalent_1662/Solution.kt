package check_if_two_string_arrays_are_equivalent_1662

class Solution {
  fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    val str1 = word1.reduce { acc, s -> acc + s }
    val str2 = word2.reduce { acc, s -> acc + s }

    return str1 == str2
  }

}