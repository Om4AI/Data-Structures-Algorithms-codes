// DP - Memoization (Top down approach)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        return fetchUniquePaths(m-1, n-1, obstacleGrid, dp);
    }

    int fetchUniquePaths(int i, int j, int[][] obstacleGrid, int[][] dp){
        // Base case
        if (i==0 && j==0) return dp[0][0] = 1;
        if (i<0 || j<0) return 0;

        // Memoization check    
        if (dp[i][j] != -1) return dp[i][j];

        int left = fetchUniquePaths(i, j-1, obstacleGrid, dp);
        int up = fetchUniquePaths(i-1, j, obstacleGrid, dp);

        if (i!=0 && j!=0 && obstacleGrid[i-1][j]==1 && obstacleGrid[i][j-1]==1) return dp[i][j] = 0;
        else if (i!=0 && obstacleGrid[i-1][j] == 1)return dp[i][j] = left;
        else if (j!=0 && obstacleGrid[i][j-1] == 1) return dp[i][j] = up;
        else return dp[i][j] = left + up;
    }
}
