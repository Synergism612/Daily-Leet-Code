package question5;

public class longestPalindrome {
    /**
     * 暴力破解法
     * 自写程序
     * 效果过低
     * 超时了
     * 原理是将每个字符判断是否存在下一个相同字符
     * 然后截取出来判断是否为回文
     * 然后继续下一个相同字符
     * 直到不存在下一个相同字符
     * 进行下一个字符
     */
    public static String one(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int end = s.indexOf(c, i + 1);
            if (end == -1) {
                continue;
            }
            do {
                String middle = s.substring(i, end + 1);
                if (isStandard(middle.toCharArray()) > result.length()) {
                    result = middle;
                }
                end = s.indexOf(c, end + 1);
            } while (end != -1);
        }
        if (result.length() == 0) {
            return s.charAt(0) + "";
        }
        return result;
    }

    public static int isStandard(char[] chars) {
        boolean result = true;
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result ? length : -1;
    }

    /**
     * 优化的暴力破解法
     */
    public String two(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(one(s));
    }
}
