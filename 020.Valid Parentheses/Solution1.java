import java.util.Stack;

/**
 * 这个方案采用将右括号存储到栈上的方法，相比将左括号存储的方法更加简洁
 */

public class Solution1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s1="()";
        String s2="()[]{}]";
        String s3="(]";
        String s4="([)]";
        String s5="{[]}";
        String s6="";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));


    }
}
