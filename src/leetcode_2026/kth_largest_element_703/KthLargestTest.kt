package leetcode_2026.kth_largest_element_703

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestTest {
  @Test
  fun case1() {
    val sut = KthLargest(3, intArrayOf(4, 5, 8, 2))
    assertEquals(4, sut.add(3))
    assertEquals(5, sut.add(5))
    assertEquals(5, sut.add(10))
    assertEquals(8, sut.add(9))
    assertEquals(8, sut.add(4))
  }

  @Test
  fun case3() {
    val sut = KthLargest(1, intArrayOf())
    assertEquals(-3, sut.add(-3))
    assertEquals(-2, sut.add(-2))
    assertEquals(-2, sut.add(-4))
    assertEquals(0, sut.add(0))
    assertEquals(4, sut.add(4))
    assertEquals(4, sut.add(2))
  }
}