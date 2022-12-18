package question17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {

    /**
     * 思路就是映射数字然后遍历添加到结果列表中
     */
    public static List<String> one(String digits) {
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()){
            return result;
        }
        for (char c : digits.toCharArray()) {
            int n = Integer.parseInt(c + "");
            int index;
            int number;
            switch (n) {
                case 1: {
                    return new ArrayList<>();
                }
                case 7: {
                    index = 15;
                    number = 4;
                    break;
                }
                case 8: {
                    index = 19;
                    number = 3;
                    break;
                }
                case 9: {
                    index = 22;
                    number = 4;
                    break;
                }
                default: {
                    index = (n - 2) * 3;
                    number = 3;
                }
            }
            if (result.size() == 0) {
                result.addAll(Arrays.asList(alphabet).subList(index, number + index));
                continue;
            }
            for (String s : result) {
                for (int i = 0; i < number; i++) {
                    result.add(s + alphabet[index + i]);
                }
                result.remove(s);
            }
        }
        return result;
    }

    /**
     * 递归
     */
    public static List<String> two(String digits) {
        List<String> ans = new ArrayList<>(); //准备结果存储空间
        if (digits == null || digits.length() == 0) {  // 如果字符为空或长度为0，返回[]
            return ans;
        }
        String[] letter = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 建立数字到字母映射
        StringBuilder path = new StringBuilder(); //存储回溯过程中的字符
        process(digits, 0, letter, ans, path); // 回溯过程
        return ans;
    }
    public static void process(String digits, int index, String[] letter, List<String> ans, StringBuilder path) {
        if (index == digits.length()) { //回溯边界条件
            ans.add(path.toString());  //如果到了digits的终点，把回溯过程中的字符转化为字符串并添加到结果
            return;
        }
        int pos = digits.charAt(index) - '2'; // 得到数字到字母映射的对应位置
        for (int i = 0; i < letter[pos].length(); i++) { // 遍历当前数字对应的字母
            path.append(letter[pos].charAt(i)); // 把单个字母添加到路径
            process(digits, index + 1, letter, ans, path); // 进入下一个数字，
            path.delete(index, index + 1); //去除路径中上面添加的字母
        }

    }

    public static void main(String[] args) {
        System.out.println(two("9").toString());
    }
}
