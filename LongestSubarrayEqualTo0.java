import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayEqualTo0 {
    public static int longestSubarray(int[] arr) {
        Map<Integer, Integer> prefixSumIndexMap = new HashMap<>();
        prefixSumIndexMap.put(0, -1); // Handle the case when the subarray starts from index 0
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSumIndexMap.containsKey(prefixSum)) {
                int previousIndex = prefixSumIndexMap.get(prefixSum);
                int currentLength = i - previousIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                prefixSumIndexMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -3, 4, -4};
        System.out.println("Length of the longest subarray with sum 0: " + longestSubarray(arr));
    }
}
