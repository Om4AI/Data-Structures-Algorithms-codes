public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        Integer[][] dp = new Integer[points.length+1][4];
        return maxPoints(points,0,3,dp);
    }


    public static int maxPoints(int[][] arr, int i, int prev, Integer[][] dp){
        // Base case
        int n = arr.length;
        if(i==n-1){
            int m = Integer.MIN_VALUE;
            for(int j=0; j<=2; j++){
                if(j!=prev) m = Math.max(m, arr[i][j]);
            }
            return dp[i][prev] = m;
        }

        // Memoization check
        if(dp[i][prev]!=null) return dp[i][prev];

        // General case
        int max = Integer.MIN_VALUE;
        for(int j=0; j<=2; j++){
            if(j!=prev) max = Math.max(max, arr[i][j]+maxPoints(arr,i+1,j,dp));
        }
        return dp[i][prev] = max;
    }
}