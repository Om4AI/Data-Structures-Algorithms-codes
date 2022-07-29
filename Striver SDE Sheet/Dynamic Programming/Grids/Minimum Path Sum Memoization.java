class Solution {
    public static int m;
    public static int n;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Integer dp[][] = new Integer[m+1][n+1];
        return minPath(grid,0,0,dp);
    }

    public static int minPath(int[][] grid, int i, int j, Integer[][] dp){
        // Base condition
        if(i==m-1 && j==n-1) return dp[i][j] = grid[i][j];
        else if(i>m-1 || j>n-1) return 20001;

        // Memocheck
        if(dp[i][j]!=null) return dp[i][j];

        // General case
        int right = 0, down = 0;
        right = grid[i][j] + minPath(grid,i,j+1,dp);
        down = grid[i][j] + minPath(grid,i+1,j,dp);

        return dp[i][j] = Math.min(right,down);
    }
}