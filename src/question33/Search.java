package question33;

public class Search {
  /**
   * 普通的遍历查询
   */
  public static int one(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 判断与第一个数的大小
   * 若大于第一个数就顺序查询到被旋转的位置
   * 若小于第一个数就倒序查询到被旋转的位置
   */
  public static int two(int[] nums, int target) {
    if (target < nums[0]) {
      for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] > nums[0]) {
          break;
        }
        if (nums[i] == target) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] < nums[0]) {
          break;
        }
        if (nums[i] == target) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(two(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
  }
}
