package commons

class MaxQueue {
  private val arr = mutableListOf<Int>()

  init {
    arr.add(0)
  }

  fun size(): Int {
    return arr.size - 1
  }

  fun push(i: Int) {
    arr.add(i)

    // Percolate up
    var i = arr.size - 1
    var parent = i / 2

    while (arr[i] > arr[parent] && i > 1) {
      val tmp = arr[i]
      arr[i] = arr[parent]
      arr[parent] = tmp

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
    var i = 1
    while (i * 2 < arr.size - 1) {
      val leftChildren = i * 2
      val rightChildren = i * 2 + 1

      // First check right child
      if (
        rightChildren < arr.size - 1 &&
        arr[rightChildren] > arr[leftChildren] &&
        arr[rightChildren] > arr[i]
      ) {
        val tmp = arr[i]
        arr[i] = arr[rightChildren]
        arr[rightChildren] = tmp

        i = rightChildren
      } else if (
        leftChildren < arr.size - 1 &&
        arr[leftChildren] > arr[i]
      ) {
        val tmp = arr[i]
        arr[i] = arr[leftChildren]
        arr[leftChildren] = tmp

        i = leftChildren
      } else {
        break
      }
    }

    return out
  }
}