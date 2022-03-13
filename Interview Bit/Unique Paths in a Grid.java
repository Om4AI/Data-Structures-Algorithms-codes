public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // Start point is blocked by obstacle
        if(obstacleGrid[0][0]==1) return 0;
        int t[][] = new int[m+1][n+1];
        
        // Initialization
        for(int i=0; i<m+1; i++){
            Arrays.fill(t[i], -1);
        }
        int i=0, j=0;
        return uniquePathsII(i,j,m,n,t,obstacleGrid);
    }

    public static int uniquePathsII(int i,int j,int m,int n,int[][] t,int[][] obstacleGrid){
        
        // Base condition
        if(i==m-1 && j==n-1) return 1;

        // Check if memoization matrix has value
        if(t[i][j]!=-1) return t[i][j];

        // Actual logic 
        int right =0, down=0;
        if(i+1<=m-1 && obstacleGrid[i+1][j]==0) down = uniquePathsII(i+1,j,m,n,t,obstacleGrid);
        if(j+1<=n-1 && obstacleGrid[i][j+1]==0) right = uniquePathsII(i,j+1,m,n,t,obstacleGrid);

        return t[i][j] = right+down;
    }
}