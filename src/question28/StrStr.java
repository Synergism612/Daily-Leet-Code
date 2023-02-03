package question28;

public class StrStr {

    public static int one(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int i = 0, j = 0;
        while (true) {
            if (j == needleArray.length) {
                return i - j;
            }
            if (i == haystackArray.length) {
                return -1;
            }
            if (haystackArray[i] == needleArray[j]) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(one("sadbutsad",
                "sad"));
    }
}
