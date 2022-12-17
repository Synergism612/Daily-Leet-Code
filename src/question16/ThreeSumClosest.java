package question16;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * 双指针法
     * 遍历获取差值然后记录最小差值
     * 个人对这个 int difference = 99999; 不是很满意
     * 但也没别的办法了
     */
    public static int one(int[] nums, int target) {
        Arrays.sort(nums);
        int difference = 99999;
        int symbol = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (i < k) {
                int number = nums[i] + nums[j] + nums[k];
                int dif = target - number > 0 ? target - number : -(target - number);
                if (dif < difference) {
                    difference = dif;
                    symbol = number > target ? 1 : -1;
                }
                if (number < target && j < k) {
                    j++;
                }
                if (number > target && j < k) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (number == target) {
                    return target;
                }
            }
        }
        return target + (symbol * difference);
    }

    public static void main(String[] args) {
        System.out.println(one(new int[]{1,1,-1}, 2));
    }
}
