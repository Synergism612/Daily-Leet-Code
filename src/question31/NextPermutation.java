package question31;

import java.util.Arrays;

public class NextPermutation {

    /**
     * 精彩绝伦！
     * 拍案叫绝！
     */
    public static void one(int[] nums) {
        //例：1432
        int len = nums.length; //记录数组长度
        for (int i = len - 1; i > 0; i--) { //从后向前遍历
            //由1<4>3>2,取到索引值为1
                if (nums[i] > nums[i - 1]) { //从后向前第一处后大于前，取后者索引
                    //从索引为1以及之后排序变为1234
                    Arrays.sort(nums, i, len); //从索引处向后排序
                    for (int j = i; j <len; j++) { //转向遍历，从索引处向后遍历
                        //转向遍历，找到比索引为0大的第一个值为2
                        if (nums[j] > nums[i - 1]) { //寻找比后大于前时的前者大的最小数
                            //开始交换两值 2134
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            //返回2134
                            return; //返回
                        }
                    }
                }
            }
    	Arrays.sort(nums); //若是没有符合条件的，直接排序
		return; //返回
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        one(nums);
        System.out.println(Arrays.toString(nums));
    }
}
