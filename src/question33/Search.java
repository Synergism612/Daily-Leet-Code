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

  /**
   * 二分法
   */
  public static int three(int[] nums, int target) {
    // 获取长度
    int n = nums.length;
    // 特例
    if (n == 0) {
      return -1;
    }
    if (n == 1) {
      return nums[0] == target ? 0 : -1;
    }
    // 左指针，右指针
    int l = 0, r = n - 1;
    // 从左到右循环
    while (l <= r) {
      // 二分，获取中位
      int mid = (l + r) / 2;
      // 直接输出
      if (nums[mid] == target) {
        return mid;
      }
      // 中位大于等于第一次说明从0-mid位都是顺序的
      if (nums[0] <= nums[mid]) {
        // 检查target是否在此范围
        if (nums[0] <= target && target < nums[mid]) {
          // 在的话将右指针移动到mid-1，缩小范围到l-mid中
          r = mid - 1;
        } else {
          // 不在说明在另外一半，将左指针移动到mid+1，缩小范围到mid-r
          l = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[n - 1]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(two(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
  }
}
