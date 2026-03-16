package commons

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinQueueTests {
  @Test
  fun whenInserting_itShouldPopTheInsertedValue() {
    val minQueue = MinQueue()
    minQueue.push(9)
    val result = minQueue.pop()

    assertEquals(9, result)
  }

  @Test
  fun whenPopping_theValueShouldBeRemoved() {
    val minQueue = MinQueue()
    minQueue.push(9)
    minQueue.pop()
    val result = minQueue.pop()

    assertEquals(null, result)
  }

  @Test
  fun initialSizeIsZero() {
    val minQueue = MinQueue()
    assertEquals(0, minQueue.size())
  }

  @Test
  fun whenPushing_sizeShouldBeOne() {
    val minQueue = MinQueue()
    minQueue.push(9)
    assertEquals(1, minQueue.size())
  }

  @Test
  fun whenPopping_sizeShouldDecrease() {
    val minQueue = MinQueue()
    minQueue.push(9)
    minQueue.pop()
    assertEquals(0, minQueue.size())
  }

  @Test
  fun poppingOrder_1() {
    val minQueue = MinQueue()
    minQueue.push(3)
    minQueue.push(2)
    minQueue.push(1)

    assertEquals(1, minQueue.pop())
    assertEquals(2, minQueue.pop())
    assertEquals(3, minQueue.pop())
  }

  @Test
  fun poppingOrder_2() {
    val minQueue = MinQueue()
    minQueue.pushAll(intArrayOf(9, 4, 8, 5, 7, 3, 1, 2, 6))

    assertArrayEquals(
      intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
      minQueue.popAll()
    )
  }

  @Test
  fun negativeValues() {
    val minQueue = MinQueue()
    minQueue.push(3)
    minQueue.push(2)
    minQueue.push(-1)

    assertEquals(-1, minQueue.pop())
    assertEquals(2, minQueue.pop())
    assertEquals(3, minQueue.pop())
  }

}