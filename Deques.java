import java.util.Deque;
import java.util.LinkedList;

public class Deques {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);
        System.out.println(deque); 
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);

        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

    }
}
