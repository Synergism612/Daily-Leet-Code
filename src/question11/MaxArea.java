package question11;

public class MaxArea {

    /**
     * 遍历法
     * 太慢了
     */
    public static int one(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int result = (Math.min(height[i], height[j]))*(j-i);
                if (result>max){max = result;}
            }
        }
        return max;
    }

    /**
     * 双指针
     * 左右开工
     * 速度快
     */
    public static int two(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while (i!=j){
            int number;
            if (height[i]>height[j]){
                number = height[j]*(j-i);
                if (number>max){
                    max = number;
                }
                j--;
            }else{
                number = height[i]*(j-i);
                if (number>max){
                    max = number;
                }
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(two(numbers));
    }
}
