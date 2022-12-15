package question14;

public class LongestCommonPrefix {

    /**
     *
     */
    public static String one(String[] strs) {
        int min = strs[0].length();
        for (String str : strs) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        int i = 1;
        int j = 1;
        String result = "";
        while (i <= min) {
            for (String str : strs) {
                if (str.length() == 0) {
                    return "";
                }
                String sub = str.substring(0, i);
                if (result.length() == 0) {
                    result = sub;
                    continue;
                }
                if (j == i - 1) {
                    result = sub;
                    j++;
                    continue;
                }
                if (!sub.equals(result)) {
                    return result.substring(0, i - 1);
                }
            }
            i++;
        }
        return result;
    }

    /**
     * 用了string.startsWith()函数
     * 该函数判断字符串是否有指定的前缀
     */
    public static String two(String[] strs) {
        if(strs.length==0)return "";
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(two(new String[]{"flower", "flow", "flight"}));
    }
}
