package contains_duplicate_II_219


class Solution {
  fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = HashSet<Int>();
    var left = 0;

    for (right in 0 until nums.size) {
      if (right - left - 1 == k) {
        set.remove(nums[left]);
        left++;
      }

      if (set.contains((nums[right]))) {
        return true;
      }

      set.add(nums[right]);
    }

    return false;
  }
}