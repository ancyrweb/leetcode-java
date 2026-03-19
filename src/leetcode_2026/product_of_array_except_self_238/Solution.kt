package leetcode_2026.product_of_array_except_self_238

class Solution {
  fun productExceptSelf(nums: IntArray): IntArray = prefixSuffixProducts(nums)

  /**
   * The idea is to construct a Prefix Factor and a Suffix Factor
   * Thus, in the first array, the index `i` contains the factor of all elements up to `i`
   * We do the same with a Suffix Factor array that works backward (from end to start).
   *
   * Thus, at any given index `i` :
   * - The factor of all elements up to `i` is stored in `prefix[i - 1]`
   * - The factor of all elements next to `i` is stored in `suffix[i + 1]`
   * All we have to do is multiply them and we know for sure that `i` is not included.
   *
   * Notes : check boundaries.
   */
  fun prefixSuffixProducts(nums: IntArray): IntArray {
    val prefix = IntArray(nums.size)
    val suffix = IntArray(nums.size)

    for (i in nums.indices) {
      prefix[i] = if (i == 0) nums[i] else prefix[i - 1] * nums[i]
    }

    for (i in nums.size - 1 downTo 0) {
      suffix[i] = if (i == nums.size - 1) nums[i] else suffix[i + 1] * nums[i]
    }

    val out = IntArray(nums.size)
    for (i in nums.indices) {
      val p = if (i == 0) 1 else prefix[i - 1]
      val s = if (i == nums.size - 1) 1 else suffix[i + 1]
      out[i] = p * s
    }

    return out
  }


  fun bruteForce(nums: IntArray): IntArray {
    val copy = IntArray(nums.size) { 1 }

    for (i in 0 until copy.size) {
      for (j in 0 until copy.size) {
        if (i != j) {
          copy[i] *= nums[j]
        }
      }
    }

    return copy
  }
}