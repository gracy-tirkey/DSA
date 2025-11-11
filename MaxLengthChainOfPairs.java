import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int[][] pairs = { {5,24}, {39,60}, {5,28}, {27,40}, {50,90} };
        System.out.println("Maximum length of chain is: " + findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        // Sort the pairs based on the second element
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int count = 0;
        int currentEnd = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                count++;
                currentEnd = pair[1];
            }
        }

        return count;
    }
}
