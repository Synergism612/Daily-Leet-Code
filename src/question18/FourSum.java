package question18;

import java.util.*;

public class FourSum {
    /**
     * 双层循环加双指针
     */
    public static List<List<Integer>> one(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int x = j + 1;
                int y = nums.length - 1;
                while (x < y) {
                    long number = (long)nums[i] + nums[j] + nums[x] + nums[y];
                    if (number < target) {
                        x++;
                        continue;
                    }
                    if (number > target) {
                        y--;
                        continue;
                    }
                    String key = "" + nums[i] + nums[j] + nums[x] + nums[y];
                    if (!strings.contains(key)) {
                        strings.add(key);
                        result.add(List.of(nums[i], nums[j], nums[x], nums[y]));
                    }
                    while (x < y){
                        if (nums[x] != nums[++x]){
                            break;
                        }
                    }
                    while (x < y){
                        if (nums[y] != nums[--y]){
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 官方答案在两次循环中优化了很多
     *
     */
    public List<List<Integer>> two(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        one(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296)
                .forEach(integers -> System.out.println(integers.toString()));
    }
}
