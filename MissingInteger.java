public class MissingInteger {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 5 }; // Example array with a missing integer
        int missingInteger = findMissingInteger(nums);
        System.out.println("The missing integer is: " + missingInteger);
    }
    public static int findMissingInteger(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length + 1; // since one integer is missing
        int expectedSum = n * (n + 1) / 2; // sum of first n natural numbers
        return expectedSum - sum; // the missing integer
    }
}
