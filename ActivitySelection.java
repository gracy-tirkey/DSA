import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum number of activities that can be performed: " + maxActivities(start, end, n));
    }

    static int maxActivities(int[] start, int[] end, int n) {

        // sorting activities based on their end times
        int activities[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i]; 
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> selectedActivities = new ArrayList<>();
        int count = 0;
        int lastEndTime = -1;

        for (int i = 0; i < n; i++) {
            if (activities[i][1] >= lastEndTime) {
                count++;
                selectedActivities.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }
        System.out.println("Selected activities (0-based indices): " + selectedActivities);

        return count;
    }
}
