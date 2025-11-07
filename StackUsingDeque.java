import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        
        public void push(int data){
            deque.addFirst(data);
        }
        public int pop(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
        public boolean isEmpty(){
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
