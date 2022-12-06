package question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheSumOfTwoNumbers {
    /**
     * 暴力枚举
     * 利用循环遍历寻找结果
     * 注意第二次循环要从 j = i + 1 开始
     * 时间复杂度 O(n*n)  n 是数组中的元素数量
     * 空间复杂度 O(1)
     */
    public static int[] one(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     * 将数组中的值按照
     * key: target - num 与目标的差值
     * value: index num的下标
     * 方式存入哈希表中，直到遍历到哈希表中存在的差值
     * 时间复杂度 O(n) n是数组中的元素数量
     * 空间复杂度 O(n) n是数组中的元素数量
     */
    public static int[] two(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number)) {
                return new int[]{map.get(number), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        long start;
        long end;
        int[] nums = {3, 2, 3};
        int target = 6;
        start = System.nanoTime();
        System.out.println(Arrays.toString(one(nums, target)));
        end = System.nanoTime();
        System.out.println("耗时" + (end - start));
        start = System.nanoTime();
        System.out.println(Arrays.toString(two(nums, target)));
        end = System.nanoTime();
        System.out.println("耗时" + (end - start));
    }
}
