import java.util.*;

public class Solution {
    public static int n;
    public static int m;
    public int solve(int[][] grid){
        n = grid.length;
        m = grid[0].length;

        // Edge case
        if(n==1 && m==1) return 1;

        Integer dp[][] = new Integer[n+1][m+1];

        int res = getPaths(grid,0,0,dp);
        return (res==1 || res<(n+m-1))?-1:res;
    }


    public static int getPaths(int[][] grid, int i, int j, Integer[][] dp){
        // Base case
        if(i==n-1 && j==m-1) return dp[i][j] = 1;
        else if(i>n-1 || j>m-1) return 0;

        // Memoization check
        if(dp[i][j]!=null) return dp[i][j];

        // Cases
        int right = 1, down = 1;
        if(j<m-1 && grid[i][j+1]>grid[i][j]){
            right = 1+getPaths(grid,i,j+1,dp);
        }

        if(i<n-1 && grid[i+1][j] > grid[i][j]){
            down = 1+getPaths(grid,i+1,j,dp);
        }

        return dp[i][j] = Math.max(right,down);
    }
}
