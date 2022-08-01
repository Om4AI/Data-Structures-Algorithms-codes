class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        
        // Bottom Up Approach
        for(int i=n-1; i>=0; i--){
            // Base cases
            if(i==n-1) dp[i] = 1;
            else if(i==n-2) dp[i] = 2;
            else{
                dp[i] = dp[i+1]+dp[i+2];
            }
        }
        return dp[0];
    }
}