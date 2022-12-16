package question15;

import java.util.*;

public class ThreeSum {
    /**
     * 哈希表写法
     * 参考了两数之和
     * 若nums[i]>0，则不可能出现结果，直接返回
     * 若nums[i] == nums[i - 1]，说明重复，需要跳过
     */
    public static List<List<Integer>> one(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int number = target - nums[j];
                if (map.containsKey(number)) {
                    List<Integer> integerList = List.of(nums[i], nums[map.get(number)], nums[j]);
                    if (index == -1 || !result.get(index).equals(integerList)) {
                        index++;
                        result.add(integerList);
                    }
                    map.remove(number);
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return result;
    }

    /**
     * 双指针写法
     * 利用双指针加速遍历
     * 若三者相加小于0，说明j指针太左，需要j++
     * 若三者相加大于0，说明k指针太右，需要k--
     * 若三者相加等于0，写入结果集后需要将这两个数全部从nums中剔除
     */
    public static List<List<Integer>> two(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (nums[i] + nums[j] + nums[k] < 0 && j < k) {
                    j++;
                }
                while (nums[i] + nums[j] + nums[k] > 0 && j < k) {
                    k--;
                }
                if (j == k)
                    break;
                // 如果满足条件的话
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while ((j < k) && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = two(new int[]{0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2});
        result.forEach(integers -> {
            integers.forEach(System.out::print);
            System.out.println();
        });
    }
}
