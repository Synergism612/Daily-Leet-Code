package question20;

import java.util.Stack;

public class IsValid {

    /**
     * 自写方法，利用栈的特性
     * 思路是对的，但是不够简洁
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (stack.empty()) {
                return false;
            }
            if (c == ')' || c == ']' || c == '}') {
                Character t = null;
                switch (stack.pop()) {
                    case '{':
                        t = '}';
                        break;
                    case '[':
                        t = ']';
                        break;
                    case '(':
                        t = ')';
                        break;
                }
                if (t == null || c != t) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * 很精妙
     * 极大的简化了入栈出栈和比对
     */
    public boolean two(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([{}]]"));
    }
}
