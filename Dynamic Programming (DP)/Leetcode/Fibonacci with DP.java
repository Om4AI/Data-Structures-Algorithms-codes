// Memoization Approach (Top Down Approach)
// TC - O(n) || SC - O(n)

class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(t,-1);
        
        return getFib(n,t);
    }
    
    
    public static int getFib(int n,int[] t){
        // Base case
        if(n<=1) return dp[n] = n;
        
        // Memoization
        if(dp[n]!=-1) return dp[n];
        
        return dp[n] = getFib(n-1,dp) + getFib(n-2,dp);
    }
}


// Bottom Up Approach - (Tabulation method)
class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        
        // Initialization
        if(n<=1) return dp[n] = n;
        dp[0] = 0;
        dp[1] = 1;

        // Fill the values
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
