package commons

import java.util.*

class MaxQueue {
  private val arr = mutableListOf<Int>()

  init {
    arr.add(0)
  }

  fun heapify(nums: IntArray) {
    arr.clear()
    arr.add(0)

    for (n in nums) {
      arr.add(n)
    }

    val initial = arr.size / 2
    for (i in initial downTo 1) {
      percolateDown(i)
    }
  }

  fun size(): Int {
    return arr.size - 1
  }

  fun push(value: Int) {
    arr.add(value)

    // Percolate up
    var i = arr.size - 1
    var parent = i / 2

    while (arr[i] > arr[parent] && i > 1) {
      Collections.swap(arr, i, parent)
      i = parent
      parent = i / 2
    }
  }

  fun pop(): Int? {
    if (size() == 0) {
      return null
    } else if (size() == 1) {
      return arr.removeAt(1)
    }

    val out = arr[1]
    arr[1] = arr.removeLast()

    // Percolate down algorithm
    percolateDown(1)

    return out
  }

  private fun percolateDown(initial: Int) {
    var i = initial
    while (i * 2 < arr.size) {
      val leftChild = i * 2
      val rightChild = i * 2 + 1

      // First check right child
      if (
        rightChild < arr.size &&
        arr[rightChild] > arr[leftChild] &&
        arr[rightChild] > arr[i]
      ) {
        Collections.swap(arr, i, rightChild)
        i = rightChild
      } else if (
        leftChild < arr.size &&
        arr[leftChild] > arr[i]
      ) {
        Collections.swap(arr, i, leftChild)
        i = leftChild
      } else {
        break
      }
    }
  }
}