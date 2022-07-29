class Solution {
    public static int m;
    public static int n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Base case
        int[][] dp = new int[m][n];

        // Loops
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                // Base conditions
                if(grid[i][j]==1) dp[i][j] = 0;
                else if(i==m-1 && j==n-1) dp[i][j] = 1;
                
                // General case
                else{
                    int down = 0, right =0;
                    if(i<m-1) down = dp[i+1][j];
                    if(j<n-1) right = dp[i][j+1];
                    dp[i][j] = right+down;
                }
            }
        }
        return dp[0][0];
    }
}