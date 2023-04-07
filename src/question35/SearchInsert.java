package question35;

public class SearchInsert {

    public static int one(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left != right && right - left != 1) {
            int centre = (left + right) / 2;
            if (target > nums[centre]) {
                left = centre;
            }
            if (target < nums[centre]) {
                right = centre;
            }
            if (target == nums[centre]) {
                return centre;
            }
        }
        if (target <= nums[left]) return left;
        if (target > nums[right]) return ++right;
        return right;
    }

    public static void main(String[] args) {
        System.out.println(one(new int[]{1, 3}, 3));
    }
}
