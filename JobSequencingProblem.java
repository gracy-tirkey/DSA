import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem{
    public static class Job{
        char job_id;
        int dead_line;
        int profit;
        Job(char job_id, int dead_line, int profit){
            this.job_id = job_id;
            this.dead_line = dead_line;
            this.profit = profit;
        }
    }
    
    static void printJobScheduling(ArrayList<Job> arr){
        int n = arr.size();
        Collections.sort(arr,(a, b) ->{
            return a.dead_line - b.dead_line;
        });

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });

        for(int i = n - 1; i >= 0; i--){
            int slot = (i == 0) ? arr.get(i).dead_line : arr.get(i).dead_line - arr.get(i - 1).dead_line;
            maxHeap.add(arr.get(i));

            while(slot > 0 && !maxHeap.isEmpty()){
                result.add(maxHeap.poll());
                slot--;
            }
        }

        Collections.sort(result, (a,b) -> {
            return a.dead_line - b.dead_line;
        });

        for(Job job: result){
            System.out.print(job.job_id+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        System.out.println("Following is the maximum profit sequence of jobs:");
        printJobScheduling(arr);

    }
}
