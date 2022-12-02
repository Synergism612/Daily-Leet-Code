package question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheSumOfTwoNumbers {
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
