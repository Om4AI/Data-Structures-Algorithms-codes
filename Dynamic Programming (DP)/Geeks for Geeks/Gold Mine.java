class Solution{
    public static int n;
    public static int m;
    static int maxGold(int n1, int m1, int grid[][]){
        int res = Integer.MIN_VALUE;
        n = n1;
        m = m1;

        Integer dp[][] = new Integer[n+1][m+1];
        for(int i=0; i<n; i++){
            int t = maxG(i,0,grid,dp);
            res = Math.max(res, t);
        }
        return res;
    }


    public static int maxG(int i, int j, int[][] grid, Integer[][] dp){
        // Base case
        if(i>n-1 || j>m-1) return 0;
        else if(i<0) return 0;

        // Memocheck
        if(dp[i][j]!=null) return dp[i][j];

        // General case
        int rup = 0, rdown = 0,rmid = 0;
        rup = grid[i][j]+maxG(i-1,j+1,grid,dp);
        rmid = grid[i][j]+maxG(i,j+1,grid,dp);
        rdown = grid[i][j]+maxG(i+1,j+1,grid,dp);

        return dp[i][j] = Math.max(rup,Math.max(rmid,rdown));
    }
}