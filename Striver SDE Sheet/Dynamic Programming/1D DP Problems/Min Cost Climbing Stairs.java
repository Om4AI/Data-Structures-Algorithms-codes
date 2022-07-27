import java.util.*;

class Solution {
    public static int[] arr;
    public int minCostClimbingStairs(int[] cost){
        arr = cost;
        return minCost(arr.length);
    }
    
    public static int minCost(int n){

        // Initialize & fill dp array
        int dp[] = new int[n+1];
        dp[n-1] = arr[n-1];
        dp[n-2] = arr[n-2];
        for(int i=n-3; i>=0; i--){
            dp[i] = arr[i] + Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}