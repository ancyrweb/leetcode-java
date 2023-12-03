package reverse_bits_190

class Solution {
  // you need treat n as an unsigned value
  fun reverseBits(n: Int): Int {
    var x = n
    var out = 0

    for (i in 0..32) {
      out = out shl 1
      out = out or (x and 1)
      x = x shr 1
    }

    return out
  }


}