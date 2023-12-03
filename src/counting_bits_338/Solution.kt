package counting_bits_338

class Solution {
  fun countBits(n: Int): IntArray {
    val result = IntArray(n + 1) { 0 }

    for (i in 0..n) {
      var x = i
      var count = 0
      while (x != 0) {
        if (x and 1 == 1) {
          count++
        }

        x = x ushr 1
      }

      result[i] = count
    }

    return result
  }
}