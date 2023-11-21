package container_with_most_water_11;

import java.util.HashMap;

class Solution {
  public int maxArea(int[] height) {
    int lo = 0;
    int hi = height.length - 1;
    int res = 0;

    while (lo < hi) {
      int area = (hi - lo) * Math.min(height[lo], height[hi]);
      res = Math.max(area, res);

      if (height[lo] < height[hi]) {
        lo++;
      } else {
        hi--;
      }
    }

    return res;
  }
}