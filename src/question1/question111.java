package question1;

import java.util.Arrays;

public class question111 {
    public static void main(String[] args) {
        int target = 111;
        int[] nums = {111,0,2,3,4,5,6,7};
        System.out.println(Arrays.toString(res(target, nums)));
    }
    public static int[] res(int target, int[] nums){
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
