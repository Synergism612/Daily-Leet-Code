package question12;

public class IntToRoman {

    /**
     * 想从小到大处理
     * 有点麻烦了
     */
    public static String one(int num) {
        StringBuilder result = new StringBuilder();
        String[] roman = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        int units = 1;
        while (num > 0) {
            int number = num % 10;
            int index = 2 * (units - 1);

            switch (number) {
                case 4: {
                    result.insert(0, (roman[index] + roman[index + 1]));
                    break;
                }
                case 9: {
                    result.insert(0, (roman[index] + roman[index + 2]));
                    break;
                }
                default: {
                    StringBuilder repetition = new StringBuilder();
                    if (number >= 5) {
                        number -= 5;
                        repetition.insert(0, roman[index + 1]);
                    }
                    repetition.append(roman[index].repeat(Math.max(0, number)));
                    result.insert(0, repetition.toString());
                }
            }
            units++;
            num /= 10;
        }
        return result.toString();
    }

    /**
     * 从大到小处理
     */
    public String two(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                result.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(one(1994));
    }
}
