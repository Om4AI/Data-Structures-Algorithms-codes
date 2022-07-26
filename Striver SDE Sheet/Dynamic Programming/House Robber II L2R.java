// ------------------- DP - Bottom Up Approach ----------------------
class Solution{
    public static int[] arr;
    public int rob(int[] nums){
        arr = nums;
        int n = arr.length;

        // Create new arrays by skipping 1st & Last elements
        int temp1[] = new int[n-1];
        for(int i=0; i<n-1; i++) temp1[i] = arr[i];

        int temp2[] = new int[n-1];
        for(int i=1; i<n; i++) temp2[i-1] = arr[i];
        
        // Base Case
        if(n==1) return arr[0];
        // DP call
        return Math.max(maxLoot(temp1), maxLoot(temp2));
    }

    // DP Function
    public static int maxLoot(int[] arr){
        int n = arr.length;
        Integer[] dp = new Integer[n+1];
        
        dp[n-1] = arr[n-1];
        dp[n] = 0;
        for(int i=n-2; i>=0; i--){
            dp[i] = Math.max(arr[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}