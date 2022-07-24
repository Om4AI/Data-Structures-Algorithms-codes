import java.util.*;

class Solution {
    public static int n;
    public static int[] arr;
    public boolean canCross(int[] stones){
        
        // Base condition - 1st Jump
        arr = stones;
        if(arr[1]!=1) return false;

        // DP Top Down
        Boolean[][] dp = new Boolean[arr.length][arr.length-1];

        return frogJump(1,1,1,dp);
    }

    // ---------------------------------------------------------
    public static boolean frogJump(int i, int curr, int k, Boolean[][] dp){

        // Catching up code
        while(i<arr.length && curr>arr[i]) i++;

        // Base case
        if(curr==arr[arr.length-1]) return true;
        else if(i>=arr.length || curr!=arr[i]) return false;

        // Memoization check
        if(dp[i][k]!=null) return dp[i][k];

        // General cases
        return dp[i][k] = frogJump(i+1,curr+k+1,k+1,dp) || frogJump(i+1,curr+k,k,dp) || frogJump(i+1,curr+k-1,k-1,dp);
    }
}