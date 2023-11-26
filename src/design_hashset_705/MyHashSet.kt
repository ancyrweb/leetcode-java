package design_hashset_705

class MyHashSet() {
  class Bucket {
    private val elements = mutableListOf<Int>()

    fun add(key: Int) {
      for (i in this.elements) {
        if (i === key) {
          return
        }
      }

      this.elements.add(key)
    }

    fun contains(key: Int): Boolean {
      for (i in this.elements) {
        if (i == key) {
          return true
        }
      }

      return false
    }

    fun remove(key: Int) {
      var idx = -1
      for (i in 0 until this.elements.size) {
        if (this.elements[i] == key) {
          idx = i
          break
        }
      }

      if (idx > -1) {
        this.elements.removeAt(idx)
      }
    }

    fun values(): MutableList<Int> {
      return this.elements
    }
  }

  private var size = 0
  private var capacity = 1024
  private var map = Array<Bucket?>(capacity) { _ -> null }

  fun add(key: Int) {
    val index = this.hash(key)
    if (this.map[index] == null) {
      this.map[index] = Bucket()
      this.map[index]!!.add(key)
      this.size++

      if (this.size >= this.capacity / 2) {
        this.rehash()
      }

      return
    }

    this.map[index]!!.add(key)
  }

  fun remove(key: Int) {
    val index = this.hash(key)
    if (this.map[index] == null) {
      return
    }

    this.map[index]!!.remove(key)
  }

  fun contains(key: Int): Boolean {
    val index = this.hash(key)
    if (this.map[index] == null) {
      return false
    }

    return this.map[index]!!.contains(key)
  }

  private fun hash(value: Int): Int {
    return value % capacity
  }

  private fun rehash() {
    val newCapacity = this.capacity * 2
    val newMap = Array<Bucket?>(newCapacity) { _ -> null }
    val oldMap = this.map

    this.map = newMap
    this.size = 0
    this.capacity = newCapacity

    for (i in oldMap) {
      if (i != null) {
        for (key in i.values()) {
          this.add(key)
        }
      }
    }
  }

}