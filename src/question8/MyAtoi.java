package question8;

public class MyAtoi {
    public static int one(String s) {
        char[] chars = s.toCharArray();
        int symbol = 1;
        boolean SW = true;
        long result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (i != 0&&chars[i - 1] != ' ') {
                        break;
                }
                continue;
            }
            if (chars[i] == '-') {
                if (!SW) {
                    break;
                }
                if (i != 0&&chars[i - 1] != ' ') {
                    break;
                }
                symbol = -1;
                SW = false;
                continue;
            }
            if (chars[i] == '+') {
                if (!SW) {
                    break;
                }
                if (i != 0&&chars[i - 1] != ' ') {
                    break;
                }
                SW = false;
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                result = result * 10 + (chars[i] - 48);
                if (result*symbol > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result*symbol < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                continue;
            }
            break;
        }
        result *= symbol;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(one("9223372036854775808"));
    }
}
