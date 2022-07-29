class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        // Loop -> Base -> General -> Result
        for(int i=m; i>=0; i--){
            for(int j=n; j>=0; j--){
                // Base conditions
                if(i==m-1 && j==n-1) dp[i][j] = grid[i][j];
                else if(i>m-1 || j>n-1) dp[i][j] = 20001;
                // General case
                else{
                    int right = 0, down = 0;
                    right = grid[i][j]+dp[i][j+1];
                    down = grid[i][j]+dp[i+1][j];
                    dp[i][j] = Math.min(right,down);
                }
            }
        }
        // Result
        return dp[0][0];
    }
}