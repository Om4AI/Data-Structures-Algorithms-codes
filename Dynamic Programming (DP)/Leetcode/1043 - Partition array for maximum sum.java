/*
 * 1. Always think about the expected result, the recursive function f(x) 
 *    should return that value
 * 2. Write the recursive function separately and whatever arguments are changing
 *    that is the dimensionality of the dp[] array
 * 3. In the Bottom Up approach, dp[ind] is actually the recursive function in memoization
 *    so replace every function call with dp[ind]
 */

import java.util.*;

// Memoization (Top Down)
class Solution {
    public static int[] arr;
    public static int k;
    public static int n;
    public static int[] dp;
    public int maxSumAfterPartitioning(int[] nums, int k1) {
        arr = nums;
        k = k1;
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return max_partition_sum(0);
    }

    public static int max_partition_sum(int ind){
        // Base case
        if (ind == n) return 0;

        // Memoization
        if (dp[ind]!=-1) return dp[ind];

        // Actual logic
        int len = 0, max = Integer.MIN_VALUE;
        int max_sum = 0;
        for (int i=ind; i<Math.min(n, ind+k); i++){
            len++;
            max = Math.max(max, arr[i]);

            int sum = (len*max) + max_partition_sum(i+1);
            max_sum = Math.max(max_sum, sum);
        }
        return dp[ind] = max_sum;
    }
}



// Bottom Up (Tabulation)
class Solution {
    public static int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        /*
         * Base case is covered in the initialization:
         * dp[n] = 0
         */
        dp = new int[n+1];

        // Every entry in the dp[] array - max_partition_sum(ind)
        for (int ind=n-1; ind>=0; ind--){
            int len = 0, max = Integer.MIN_VALUE;
            int max_sum = 0;
            for (int i=ind; i<Math.min(n, ind+k); i++){
                len++;
                max = Math.max(max, arr[i]);

                int sum = (len*max) + dp[i+1];
                max_sum = Math.max(max_sum, sum);
            }
            dp[ind] = max_sum;
        }
        return dp[0];
    }
}