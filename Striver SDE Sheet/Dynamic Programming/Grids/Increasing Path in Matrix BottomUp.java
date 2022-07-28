import java.util.*;
public class Solution {
    public int solve(int[][] grid){
        int n = grid.length, m = grid[0].length;
        // Edge case
        if(n==1 && m==1) return 1;

        // Initialization
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==n-1 && j==m-1) dp[i][j] = 1;
                else if(j==m-1) dp[i][j] = n-i;
                else if(i==n-1) dp[i][j] = m-j;
            }
        }


        // Fill the matrix
        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){

                // Recursion general case
                int right = 0, down =0;
                if(i<n-1 && grid[i+1][j]>grid[i][j]) right = 1+dp[i+1][j];
                if(j<m-1 && grid[i][j+1]>grid[i][j]) down = 1+dp[i][j+1];

                dp[i][j] = Math.max(right,down);
            }
        }

        return (dp[0][0]<=0 || dp[0][0]<(n+m-1) || dp[0][0]>=n*m)?-1:dp[0][0];
    }
}
