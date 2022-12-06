package question4;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double one(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int num : nums1) {
            nums[index] = num;
            index++;
        }
        for (int num : nums2) {
            nums[index] = num;
            index++;
        }
        nums = Arrays.stream(nums).sorted().toArray();
        int size = nums.length;
        if (size % 2 == 1) {
            return nums[(size - 1) / 2];
        } else {
            return (nums[(size / 2) - 1] + nums[size / 2]) / 2.0;
        }
    }

    public static double two(int[] nums1, int[] nums2) {
        double result = -1;
        int[] tmpArray = new int[nums1.length + nums2.length];
        int pos = 0;
        int pos1 = 0;
        int pos2 = 0;

        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] < nums2[pos2])
                tmpArray[pos++] = nums1[pos1++];
            else
                tmpArray[pos++] = nums2[pos2++];
        }

        while (pos1 < nums1.length)
            tmpArray[pos++] = nums1[pos1++];

        while(pos2 < nums2.length)
            tmpArray[pos++] = nums2[pos2++];

        int mid = pos / 2;
        if (pos % 2 == 0)
            result = (tmpArray[mid-1] + tmpArray[mid]) / 2.0;
        else
            result = tmpArray[mid];

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};
        System.out.println(two(nums1, nums2));
    }
}
