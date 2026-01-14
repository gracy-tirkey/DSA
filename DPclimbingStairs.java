public class DPclimbingStairs {
    // Climbing Stairs using Dynamic Programming (Memoization)
    public static int climbStairs(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }

    // Climbing Stairs using Tabulation
    public static int climbStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        // Create an array to store the number of ways to climb stairs up to n
        int[] memo = new int[n + 1];
        System.out.println("Number of ways to climb " + n + " stairs is: " + climbStairs(n, memo));
    }
}
