package leetcode_2026.topk_frequent_elements_347

class Solution {
  fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // Algorithm General Idea
    // 1. Count the number of occurrences of each number in the input array and store it in a map.
    // 2. Create an array of lists where the index is the number of occurrences of a specific number and each index contains a list of numbers that occur that many times.
    // 3. Iterate through the array of lists from the end to the beginning and add all the numbers in the lists until we have K numbers in our output list.
    // Time Complexity: O(n) because we only iterate through arrays, even if we do it twice.
    // Space Complexity: O(n) because we use a map to store the count of each number and an array of lists to store the numbers that occur a specific number of times.

    // Count the number of occurrences of each number
    val countMap = mutableMapOf<Int, Int>()
    for (num in nums) {
      countMap[num] = countMap.getOrDefault(num, 0) + 1
    }

    // Create an array where the index is the number of occurences of a specific number
    // Each index in this array contains a list of numbers that occur that many times
    // For example, frequenciesList[3] contains a list of numbers that occur 3 times in the input array.

    // Note : we need to add +1 to the size of the frequenciesList because if a number occurs N times,
    // it will be added to the list at index N. If we don't add +1, we will get an IndexOutOfBoundsException
    // when we try to add a number that occurs N times to the list at index N.
    val frequenciesList = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
    for ((num, count) in countMap) {
      frequenciesList[count].add(num)
    }


    val out = mutableListOf<Int>()

    // Now the frequencies are sorted from lowest frequency to highest.
    // We want the K most frequent elements so we need to iterate from the end of the frequenciesList
    // to the beginning and add all the numbers in the lists until we have K numbers in our output list.
    for (i in frequenciesList.size - 1 downTo 0) {
      if (frequenciesList[i].isNotEmpty()) {
        // Note : elements will not be sorted.
        out.addAll(frequenciesList[i])
      }

      if (out.size >= k) {
        // End loop once K is reached
        break
      }
    }

    return out.toIntArray()
  }
}