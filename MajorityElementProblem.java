import java.util.HashMap;
// import java.util.Set;

public class MajorityElementProblem {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if(countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
            // countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }
        
        // Set<Integer> keys = countMap.keySet();
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) > nums.length / 3) {
                return key;
            }
        }
        return -1; // Return -1 if no majority element found
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        System.out.println(majorityElement(nums)); // Output: 3
    }
}
