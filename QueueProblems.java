import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<Character>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interleaveBtn2Halves(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size() / 2;

        for(int i=0; i<size; i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        interleaveBtn2Halves(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        reverseQueue(q2);
        while(!q2.isEmpty()){
            System.out.print(q2.remove() + " ");
        }
        System.out.println();
    }   
}
