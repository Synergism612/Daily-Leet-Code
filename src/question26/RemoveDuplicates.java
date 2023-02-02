package question26;

import java.util.Arrays;

public class RemoveDuplicates {
    /**
     * 很奇怪为啥我本来写的这个不能通过
     * 好像是因为不能在[]里用++?
     * 不过原理一样
     * 双指针算法
     * 我多考虑了，实际上应该和第二个一样简洁
     */
    public static int one(int[] nums) {
        int i = 0,j = 0;
        while (j < nums.length - 1 && nums[i] <= nums[j]) {
            if (nums[i] == nums[j]) {
                j++;
            }
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j++];
            }
        }
        return j;
    }

    public static int two(int[] nums) {
        int i = 0,j =1;
        while(j<nums.length){
            if (nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,2};
        System.out.println(one(ints));
        System.out.println(Arrays.toString(ints));
    }
}
