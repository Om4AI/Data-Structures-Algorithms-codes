import java.util.*;

class Solution {
    public static int m;
    public static int n;
    public int uniquePaths(int m1, int n1){
        m = m1;
        n = n1;
        Integer[][] dp = new Integer[m+1][n+1];
        return paths(0,0,dp);
    }

    public static int paths(int i, int j, Integer[][] dp){
        // Base case
        if(i==m-1 && j==n-1) return dp[i][j] = 1;
        else if(i>m-1 || j>n-1) return 0;

        // Memoization check
        if(dp[i][j]!=null) return dp[i][j];

        // Case
        int right = paths(i,j+1,dp);
        int left = paths(i+1,j,dp);

        return dp[i][j] = right+left;
    }
}
