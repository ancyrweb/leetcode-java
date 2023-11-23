package two_sum_III_170

import java.util.HashMap

class TwoSum {
  val map: HashMap<Int, Int> = HashMap();

  fun add(number: Int) {
    if (map.containsKey(number)) {
      map[number] = map[number]!! + 1;
    } else {
      map[number] = 1;
    }
  }

  fun find(value: Int): Boolean {
    map.forEach { (n, count) ->
      val diff = value - n
      if (map.contains(diff) && (diff != n || count > 1)) return true
    }
    return false
  }
}