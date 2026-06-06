// Memoization - Top Down approach
class Solution {
    int minCost(int[] heights) {
        // f(n)
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCostToReach(n-1, heights, dp);
    }

    int minCostToReach(int ind, int[] heights, int[] dp){
        // Base case
        if (ind == 0) return 0;

        // DP check
        if (dp[ind] != -1) return dp[ind];

        int oneJump = minCostToReach(ind-1, heights, dp) + Math.abs(heights[ind-1] - heights[ind]);
        int twoJump = Integer.MAX_VALUE;
        if (ind > 1) {
            twoJump = minCostToReach(ind-2, heights, dp) + Math.abs(heights[ind-2] - heights[ind]);
        }
        return dp[ind] = Math.min(oneJump, twoJump);
    }
}


// Tabulation - Bottom up approach
class Solution {
    int minCost(int[] heights) {
        // f(n)
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Base case
        dp[0] = 0;

        for (int i=1; i<n; i++){
            int oneJump = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int twoJump = Integer.MAX_VALUE;
            if (i > 1){
                twoJump = dp[i-2] + Math.abs(heights[i-2] - heights[i]);
            }
            dp[i] = Math.min(oneJump, twoJump);
        }
        return dp[n-1];
    }
}