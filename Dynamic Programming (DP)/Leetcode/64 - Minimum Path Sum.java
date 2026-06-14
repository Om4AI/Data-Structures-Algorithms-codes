class Solution {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return minSum(m-1, n-1, grid, dp);
    }

    int minSum(int i, int j, int[][] grid, int[][] dp){
        // Base case
        if (i==0 && j==0) return dp[i][j] = grid[i][j];
        // The maximum value since we need to get the minimum
        // 0 <= grid[i][j] <= 200: Hence a number larger than 40k -> Integer.MAX_VALUE/10;
        if (i<0 || j<0) return Integer.MAX_VALUE/10;

        // Memoization check
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + minSum(i-1, j, grid, dp);
        int left = grid[i][j] + minSum(i, j-1, grid, dp);
        return dp[i][j] = Math.min(up, left);
    }
}