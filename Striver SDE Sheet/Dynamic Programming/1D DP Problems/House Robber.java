// ------------------- DP right to left - Memoization -------------------
class Solution {
    public int rob(int[] arr){
        int n = arr.length;

        Integer dp[] = new Integer[n+1];
        return maxLoot(arr,n-1,dp);
    }


    public static int maxLoot(int[] arr, int i, Integer[] dp){
        // Base cases
        if(i==0) return dp[i] = arr[i];
        else if(i<0) return dp[i] = 0;


        // Memoization check
        if(dp[i]!=null) return dp[i];

        // Cases - Pick & No Pick policy
        return dp[i] = Math.max(arr[i]+maxLoot(arr,i-2,dp), maxLoot(arr,i-1,dp));
    }
}

// ------------------- DP right to left - Bottom Up ---------------------
class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        Integer dp[] = new Integer[n];
        dp[0] = arr[0];
        int neg =0;
        
        for(int i=1; i<n; i++){
            int pick = arr[i];

            // Previous result if (i-2) isn't negative
            pick += (i>1)?dp[i-2]:0;
            int dontpick = dp[i-1];
            dp[i] = Math.max(pick,dontpick);
        }
        return dp[n-1];
    }
}