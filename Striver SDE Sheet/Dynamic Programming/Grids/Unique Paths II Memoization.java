class Solution {
    public static int m;
    public static int n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Integer dp[][] = new Integer[m+1][n+1];
        return paths(0,0,dp,grid);
    }


    public static int paths(int i, int j, Integer[][] dp, int[][] grid){
        // Base condition
        if(i<=m-1 && j<=n-1 && grid[i][j]==1) return dp[i][j] = 0;
        else if(i==m-1 && j==n-1) return dp[i][j] = 1;
        else if(i>m-1 || j>n-1) return 0;

        // Memocheck
        if(dp[i][j]!=null) return dp[i][j];

        // General case
        int down = 0, right =0;
        if(i<m-1 && grid[i+1][j]!=1) down = paths(i+1,j,dp,grid);
        if(j<n-1 && grid[i][j+1]!=1) right = paths(i,j+1,dp,grid);

        return dp[i][j] = right+down;
    }
}