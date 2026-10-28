class Solution {
    static int m;
    static int n;
    static int[][] grid;
    static int[][][] dp;
    public int minCost(int[][] matrix) {
        grid = matrix;
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][1024];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getMinCost(0, 0, 0);
    }

    // Cost is the existing cost till the current cell
    //  i & j -> Indices of the cell
    static int getMinCost(int i, int j, int cost){
        // Base case
        if (i==m-1 && j==n-1) return dp[i][j][cost] = cost^grid[i][j];

        // Top down approach
        if (dp[i][j][cost]!=-1) return dp[i][j][cost];
        // Edge cases
        if (i==m-1){
            dp[i][j][cost] = getMinCost(i,j+1,cost^grid[i][j]);
        }else if (j==n-1){
            dp[i][j][cost] = getMinCost(i+1,j,cost^grid[i][j]);
        }else{
            dp[i][j][cost] = Math.min(getMinCost(i,j+1,cost^grid[i][j]), getMinCost(i+1,j,cost^grid[i][j]));
        }
        return dp[i][j][cost];
    }
}