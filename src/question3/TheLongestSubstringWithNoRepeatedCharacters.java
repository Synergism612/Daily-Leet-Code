package question3;

import java.util.HashMap;
import java.util.Map;

public class TheLongestSubstringWithNoRepeatedCharacters {

    public static int one(String s){
        Map<Integer, String> map = new HashMap<>();
        StringBuilder string = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = string.indexOf(c + "");
            if (index != -1) {
                map.put(string.length(), string.toString());
                string.delete(0,index+1);
            }
            string.append(c);
        }
        map.put(string.length(), string.toString());
        int max = 0;
        for (int x : map.keySet()) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static int two(String s) {
        int max = 0;
        StringBuilder string = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = string.indexOf(c + "");
            if (index >= 0) {
                max = Math.max(string.length(), max);
                string = new StringBuilder(string.substring(index + 1));
            }
            string.append(c);
        }
        return Math.max(string.length(), max);
    }

    public static int three(String s){
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(one("ohvhjdml"));
    }
}
