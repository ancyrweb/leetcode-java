package design_hashmap_706

class MyHashMap {
  class Bucket {
    private val elements = mutableListOf<Pair>()

    fun add(pair: Pair) {
      for (i in this.elements) {
        if (i.key == pair.key) {
          i.value = pair.value
          return
        }
      }

      this.elements.add(pair)
    }

    fun find(key: Int): Int {
      for (i in this.elements) {
        if (i.key == key) {
          return i.value
        }
      }

      return -1
    }

    fun remove(key: Int) {
      var idx = -1
      for (i in 0 until this.elements.size) {
        if (this.elements[i].key == key) {
          idx = i
          break
        }
      }

      if (idx > -1) {
        this.elements.removeAt(idx)
      }
    }

    fun values(): MutableList<Pair> {
      return this.elements
    }
  }

  class Pair(var key: Int, var value: Int) {
    override fun toString(): String {
      return "{ \"$key\" : $value }"
    }
  }

  private var size = 0
  private var capacity = 1024
  private var map = Array<Bucket?>(capacity) { _ -> null }

  fun put(key: Int, value: Int) {
    val index = this.hash(key)
    if (this.map[index] == null) {
      this.map[index] = Bucket()
      this.map[index]!!.add(Pair(key, value))
      this.size++

      if (this.size >= this.capacity / 2) {
        this.rehash()
      }

      return
    }

    this.map[index]!!.add(Pair(key, value))
  }

  fun get(key: Int): Int {
    val index = this.hash(key)
    if (this.map[index] == null) {
      return -1;
    }

    return this.map[index]!!.find(key)
  }

  fun remove(key: Int) {
    val index = this.hash(key)
    if (this.map[index] == null) {
      return
    }

    this.map[index]!!.remove(key)
  }

  fun debug() {
    println(map.toList())
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
        for (v in i.values()) {
          this.put(v.key, v.value)
        }
      }
    }
  }
}


fun main() {
  val obj = MyHashMap()
  obj.put(1, 1)
  obj.put(2, 2)
  println(obj.get(1))
  println(obj.get(3))
  obj.put(2, 1);
  println(obj.get(2));
}