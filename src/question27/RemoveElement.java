package question27;

import java.util.Arrays;

public class RemoveElement {

    /**
     * 双指针都从左侧开始
     */
    public static int one(int[] nums, int val) {
        int i = 0,j = 0;
        while (true){
            if (j>=nums.length){
                return i;
            }
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
    }

    /**
     * 双指针从首尾开始
     */
    public static int two(int[] nums, int val) {
        int left = 0,right = nums.length;
        while (left<right){
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(two(ints,2));
        System.out.println(Arrays.toString(ints));
    }
}
