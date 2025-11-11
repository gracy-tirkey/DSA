import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double ratio[][] = new double[values.length][2];
        for (int i = 0; i < values.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) values[i] / weights[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weights[idx]) {
                capacity -= weights[idx];
                finalValue += values[idx];
            } else {
                finalValue += values[idx] * ((double) capacity / weights[idx]);
                capacity = 0;
                break;
            }
        }
        System.out.println("Maximum value in Knapsack = " + finalValue);
    }

}
