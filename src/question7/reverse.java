package question7;

public class reverse {
    public static int one(int x) {
        long result = 0;
        while (x != 0) {
            int n = x % 10;
            result = result * 10 + n;
            x = x / 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(one(-1534236469));
    }
}
