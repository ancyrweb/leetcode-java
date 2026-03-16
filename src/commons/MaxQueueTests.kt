package commons

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxQueueTests {
  @Test
  fun queueIsInitiallyEmpty() {
    val queue = MaxQueue()
    assertEquals(0, queue.size())
  }

  @Test
  fun whenAddingAnElement_queueSizeIncreases() {
    val queue = MaxQueue()
    queue.push(100)
    assertEquals(1, queue.size())
  }

  @Test
  fun poppingFromEmptyQueue() {
    val queue = MaxQueue()
    val value = queue.pop()

    assertEquals(null, value)
  }

  @Test
  fun poppingAnElementFromTheQueue() {
    val queue = MaxQueue()
    queue.push(100)
    val value = queue.pop()

    assertEquals(100, value)
    assertEquals(0, queue.size())
  }

  @Test
  fun orderingProperty() {
    val queue = MaxQueue()
    pushAll(queue, intArrayOf(5, 50, 25, 100))
    val out = popAll(queue)

    assertArrayEquals(intArrayOf(100, 50, 25, 5), out)
  }


  @Test
  fun heapify() {
    val queue = MaxQueue()
    queue.heapify(intArrayOf(5, 50, 25, 100, 200))
    val out = popAll(queue)

    assertArrayEquals(intArrayOf(200, 100, 50, 25, 5), out)
  }

  private fun pushAll(queue: MaxQueue, list: IntArray) {
    for (i in list) {
      queue.push(i)
    }
  }

  private fun popAll(queue: MaxQueue): IntArray {
    val out = mutableListOf<Int>()
    while (queue.size() > 0) {
      out.add(queue.pop()!!)
    }

    return out.toIntArray()
  }
}