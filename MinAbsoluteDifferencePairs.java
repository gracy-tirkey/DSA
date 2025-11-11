import java.util.Arrays;

public class MinAbsoluteDifferencePairs {
    public static void main(String[] args) {
        int[] A = {4, 1, 8, 3};
        int[] B = {2, 3, 6, 5};
        int result = minAbsoluteDifferenceSum(A, B);
        System.out.println("Minimum Absolute Difference Sum: " + result);
    }

    public static int minAbsoluteDifferenceSum(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int totalDifference = 0;
        for (int i = 0; i < A.length; i++) {
            totalDifference += Math.abs(A[i] - B[i]);
        }
        return totalDifference;
    }

}
