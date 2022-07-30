class Solution {
    static Long numberOfWays(int n) {
        Long dp[] = new Long[n+1];
        return numWays(n,dp)%1000000007;
    }
    
    public static long numWays(int n, Long[] dp){
        // Base case
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 2;
        
        // Memocheck
        if(dp[n]!=null) return dp[n];
        
        return dp[n] = numWays(n-1,dp)%1000000007 + numWays(n-2,dp)%1000000007;
    }
};
