import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class QueueFramework {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.poll()); // poll() returns and removes the head
        }
        
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(4);
        q2.add(5);
        q2.add(6);
        while (!q2.isEmpty()) {
            System.out.println(q2.poll());
        }
    }
}