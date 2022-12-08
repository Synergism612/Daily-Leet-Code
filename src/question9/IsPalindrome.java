package question9;

public class IsPalindrome {
    /**
     * 将获取到的数字拷贝后倒过来
     * 判断是否相等
     * 当倒转后的数字超过整型的范围就会出现错误
     * 所以用长整型
     * 更推荐第二种方法
     */
    public static boolean one(int x) {
        int copy = x;
        long result = 0;
        while (copy > 0) {
            result = result * 10 + copy % 10;
            copy /= 10;
        }
        return result==x;
    }

    /**
     * 注意到当x为负数时必然不会为回文
     * x只有一位数的时候也不会为回文
     * 原理是获取x一半，倒转对比另一半
     * 获取一半的关键在于看x是否大于result
     */
    public static boolean two(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return x == result || x == result / 10;
    }

    public static void main(String[] args) {
        System.out.println(one(12321));
    }
}
