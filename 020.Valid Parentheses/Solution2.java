import java.util.Stack;

public class ValidParentheses20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // 这里一开始没想到在stack中存储字符，而是存的字符串，然后又将输入的字符串用split分隔成字符串数组，太笨了，
        // 很明显，我们是对输入字符串中的每个字符做处理，那么我们要么将s转为字符数组，要么就用for循环搭配charAt()
        // 遍历每个每个字符
        // String[] strings=s.split("");
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //这里应该使用!=号做判断而不是==号，若用后者那么会多做多余的循环，而前者在判断到不匹配时直接返回，效率更高
                if (c == ')' && stack.peek() != '(' || c == ']' && stack.peek() != '[' || c == '}' && stack.peek() == '}') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}]";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));


    }
}
