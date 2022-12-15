package question13;

public class RomanToInt {
    /**
     * 模拟解法
     * 将字符串倒转读取
     * 遇到小于上一个的字符就减去
     * 大于等于就加上
     */
    public static int one(String s) {
        int[] values = {1,5,10,50,100,500,1000};
        char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int result = 0;
        int index = -1;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = 0; j < roman.length; j++) {
                if (chars[i] == roman[j]){
                    if (index<0){
                        index = j;
                    }
                    if (j>=index){
                        result+=values[j];
                    }else {
                        result-=values[j];
                    }
                    index = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(one("LVIII"));
    }
}
