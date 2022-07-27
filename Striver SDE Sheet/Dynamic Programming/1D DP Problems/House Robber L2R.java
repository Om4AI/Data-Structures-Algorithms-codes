// -------------------- DP - Left to Right - Memoization ------------------------
class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        Integer[] dp = new Integer[n];
        return maxLoot(arr,0,dp);
    }

    public static int maxLoot(int[] arr, int i, Integer[] dp){
        // Base case
        int n = arr.length;
        if(i==n-1) return dp[i] = arr[n-1];
        else if(i>n-1) return 0;

        // Memoization check
        if(dp[i]!=null) return dp[i];

        // General cases - Take or ignore
        return dp[i] = Math.max(arr[i]+maxLoot(arr,i+2,dp), maxLoot(arr,i+1,dp));
    }
}



// ---------------------- DP - Left to right - Bottom Up ---------------------------
class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+2];

        // Initialization
        dp[n-1] = arr[0];
        dp[n+1] = 0;

        // Fill up dp array
        for(int i=n-1; i>=0; i--){
            dp[i] = Math.max(arr[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}