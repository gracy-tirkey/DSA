public class DP01knapsack {

    // 0/1 Knapsack using Recursion
    public static int knapsack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            //include the item
            int ans1 = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1);
            //exclude the item
            int ans2 = knapsack(W, wt, val, n - 1);
            return Math.max(ans1, ans2);
        } else {
            // invalid case
            return knapsack(W, wt, val, n - 1);
        }
    }
    // 0/1 Knapsack using Dynamic Programming (Memoization)
    public static int knapsack(int W, int wt[], int val[], int n, int[][] memo) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1, memo);
            int ans2 = knapsack(W, wt, val, n - 1, memo);

            memo[n][W] = Math.max(ans1, ans2);
        } else {
            memo[n][W] = knapsack(W, wt, val, n - 1, memo);
        }
        return memo[n][W];
    }

    // 0/1 Knapsack using Tabulation
    public static int knapsackTabulation(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        // Create a memoization table initialized to -1
        int[][] memo = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println("Maximum value in knapsack: " + knapsack(W, wt, val, n, memo));
    }
}