import java.util.*;

// Memoization - Top Down approach
class Solution {
    //  f(ind) - Maximum amount of money we robbed till that index
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, arr, dp);
    }

    int solve(int ind, int[] arr, int[] dp){
        // Base cases
        if (ind == 0) return dp[ind] = arr[ind];
        if (ind < 0) return 0;

        // Memoization check
        if (dp[ind] != -1) return dp[ind];

        int pick_money = arr[ind] + solve(ind-2, arr, dp);
        int nonpick_money = 0 + solve(ind-1, arr, dp);
        return dp[ind] = Math.max(pick_money, nonpick_money);
    }
}


// Tabulation - Bottom Up approach
class Solution {
    //  f(ind) - Maximum amount of money we robbed till that index
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = arr[0];
        for (int i=1; i<n; i++){
            if (i==1){
                dp[i] = Math.max(arr[i], dp[i-1]);
                continue;
            }
            int pick = arr[i] + dp[i-2];
            int nonpick = dp[i-1];
            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n-1];
    }
}