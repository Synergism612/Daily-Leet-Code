package question32;

public class LongestValidParentheses {

  /**
   * 40ms
   */
  public static int one(String s) {
    int[] information = new int[s.length()];
    char[] charArray = s.toCharArray();
    int max = 0;
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == ')') {
        if (i - 1 < 0) {
          continue;
        }
        int startIndex = i - information[i - 1] - 1;
        if (startIndex < 0) {
          continue;
        }
        if (charArray[startIndex] == '(') {
          information[i] = information[i - 1] + 2 + (startIndex - 1 < 0 ? 0 : information[startIndex - 1]);
        }
      }
      if (information[i] > max) {
        max = information[i];
      }
    }
    return max;
  }

  /**
   * 看来以后需要少使用s.toCharArray()函数了，该函数很费时间
   * 1ms
   */
  public static int two(String s) {
    int[] information = new int[s.length()];
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (i - 1 < 0) {
          continue;
        }
        int startIndex = i - information[i - 1] - 1;
        if (startIndex < 0) {
          continue;
        }
        if (s.charAt(startIndex) == '(') {
          information[i] = information[i - 1] + 2 + (startIndex - 1 < 0 ? 0 : information[startIndex - 1]);
        }
      }
      if (information[i] > max) {
        max = information[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(one("((()))"));
    System.out.println(one(")(())())"));
  }
}
