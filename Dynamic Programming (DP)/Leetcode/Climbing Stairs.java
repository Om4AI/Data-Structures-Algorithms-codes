
// Memoization solution - Top Down approach
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return countWays(dp, n);
    }

    static int countWays(int[] dp, int n){
        // Base case
        if (n==0) return 1;
        if (n==1) return 1;

        // Check dp
        if (dp[n] != -1) return dp[n];

        return dp[n] = countWays(dp, n-1) + countWays(dp, n-2);
    }
}
