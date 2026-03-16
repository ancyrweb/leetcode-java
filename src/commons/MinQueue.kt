package commons

class MinQueue {
  val arr = mutableListOf<Int>()

  init {
    arr.add(0)
  }

  /**-
   * Push element to the min queue
   * In O(log(n))
   */
  fun push(value: Int) {
    // Value inserted at the end of the heap
    arr.add(value)

    // Percolate up until it finds its place
    var i = arr.size - 1
    var parent = i / 2

    // We add the guard i > 1 in order to prevent overiding the index 0.
    // This is because 1/2 = 0, thus the parent would be index 0
    // And since at index 0, the value is 0, inserting a negative number would
    // Percolate up to that forbidden area.
    while (i > 1 && arr[i] < arr[parent]) {
      val temp = arr[i]
      arr[i] = arr[parent]
      arr[parent] = temp

      i = parent
      parent = i / 2
    }
  }

  /**
   * Pop the minimum value
   * In O(log(n))
   */
  fun pop(): Int? {
    if (arr.size == 1) {
      return null
    } else if (arr.size == 2) {
      return arr.removeAt(1)
    }

    // Keep the min value in memory for return later
    val head = arr[1]

    // Move the last value to the top
    arr[1] = arr.removeLast()

    // Percolate down
    var i = 1
    while (2 * i < arr.size) {
      val leftChildren = 2 * i
      val rightChildren = 2 * i + 1

      // Check right children first
      if (
        rightChildren < arr.size - 1 &&
        arr[rightChildren] < arr[i] &&
        arr[rightChildren] < arr[leftChildren]
      ) {
        val temp = arr[i]
        arr[i] = arr[rightChildren]
        arr[rightChildren] = temp

        i = rightChildren
      }
      // Then check left children
      else if (
        leftChildren < arr.size - 1 &&
        arr[leftChildren] < arr[i]
      ) {
        val temp = arr[i]
        arr[i] = arr[leftChildren]
        arr[leftChildren] = temp

        i = leftChildren
      } else {
        // If none apply, we are done
        break
      }
    }

    return head
  }

  /**
   * Return the size of the queue
   * In O(1)
   */
  fun size(): Int {
    return arr.size - 1
  }

  /**
   * Return the minimum value from the queue without popping it
   * In O(1)
   */
  fun peek(): Int? {
    return if (arr.size == 1) null else arr[1]
  }

  /**
   * Push many values
   * In O(m * log(n))
   */
  fun pushAll(values: IntArray) {
    for (n in values) push(n)
  }

  /**
   * Pop all values
   * In O(n * log(n))
   */
  fun popAll(): IntArray {
    val result = mutableListOf<Int>()
    while (size() > 0) {
      val popped = pop()
      if (popped != null) {
        result.add(popped)
      }
    }

    return result.toIntArray()
  }
}