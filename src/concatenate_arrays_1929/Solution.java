package concatenate_arrays_1929;

public class Solution {
  public int[] getConcatenation(int[] nums) {
    int[] result = new int[nums.length * 2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < nums.length; j++) {
        result[i * nums.length + j] = nums[j];
      }
    }

    return result;
  }
}
