import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class QueuePracticeQuestions {

    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while(n-- > 0) {
            String s1 = queue.poll();
            System.out.println(s1);
            String s2 = s1;
            queue.add(s1 + "0");
            queue.add(s2 + "1");
        }
    }

    static int minCost(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        int res = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10; 
        generateBinaryNumbers(n);

        int arr[] = {4, 3, 2, 6};
        int size = arr.length;
        System.out.println("Minimum cost to connect ropes: " + minCost(arr, size));
    }
}
