import java.util.Stack;

public class DuplicateParentheses {
    public static void main(String[] args) {
        String expression = "((a+b)+c)";
        System.out.println(hasDuplicateParentheses(expression)); // Output: true
    }

    public static boolean hasDuplicateParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                if (stack.peek() == '(') {
                    return true; // Found duplicate parentheses
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop(); // Pop the opening parenthesis
                }
            } else {
                stack.push(c);
            }
        }
        return false; // No duplicate parentheses found
    }
}
