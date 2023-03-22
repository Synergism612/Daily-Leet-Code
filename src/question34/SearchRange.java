package question34;

import java.util.Arrays;

public class SearchRange {

  /**
   * 双指针遍历
   * 节省一丢丢的时间吧
   */
  public static int[] one(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] { -1, -1 };
    }

    int startIndex = 0;
    int endIndex = nums.length - 1;
    while (nums[startIndex] != target || nums[endIndex] != target) {
      if (nums[startIndex] != target) {
        startIndex++;
      }
      if (nums[endIndex] != target) {
        endIndex--;
      }
      if (startIndex > endIndex) {
        return new int[] { -1, -1 };
      }
    }
    return new int[] { startIndex, endIndex };
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(one(new int[] { 5,7,7,8,8,10 }, 8)));
  }
}
