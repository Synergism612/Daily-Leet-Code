package question6;

public class convert {
    public static String one(String s, int numRows) {
        if (numRows == 1)return s;
        char[] chars = s.toCharArray();
        String[] strings = new String[numRows];
        int index = 0;
        boolean SW = true;
        int i = 0;
        do {
            if (strings[i] == null) {
                strings[i] = chars[index] + "";
            } else {
                strings[i] += chars[index];
            }
            if (SW) {
                i++;
            } else {
                i--;
            }
            if (i >= numRows - 1 || i <= 0) SW = !SW;
            index++;
        } while (index < chars.length);
        String result = "";
        for (String string : strings) {
            result += string == null ? "" : string;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(one("AB", 1));
    }
}
