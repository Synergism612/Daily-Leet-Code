package question30;

import java.util.ArrayList;
import java.util.List;

public class FindSubstring {
    public static List<Integer> one(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        //判断是否满足长度大于关键字长度和
        int length = 0;
        for (String word : words) {
            length+= word.length();
        }
        if (s.length()<=length){
            return result;
        }

        for (int i = 0; i < words.length; i++) {

        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(one("barfoothefoobarman",new String[]{"foo","bar"}).toString());
    }
}
