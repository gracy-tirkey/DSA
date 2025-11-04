import java.util.Stack;

public class StackProblems {

    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        s.push(top);
    }

    public static void reverseString(Stack<Character> s){
        if(s.isEmpty()){
            return;
        }
        char top = s.pop();
        reverseString(s);
        s.push(top);
    }
    
    public static String reverseString2(Stack<Character> s){
        Stack<Character> str = new Stack<>();
        int idx = 0;
        while(idx < s.size()){
            str.push(s.get(idx));
            idx++;
        }
        StringBuilder reversed = new StringBuilder();
        while(!str.isEmpty()){
            reversed.append(str.pop());
        }
        return reversed.toString();
    }
    
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        pushAtBottom(stack,0);

        reverseStack(stack);

        Stack<Character> charStack = new Stack<>();
        for (char c : "hello".toCharArray()) {
            charStack.push(c);
        }
        System.out.println(reverseString2(charStack));
    }
}
