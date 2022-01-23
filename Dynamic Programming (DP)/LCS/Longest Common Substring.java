class Solution{
    int longestCommonSubstr(String x, String y, int n, int m){
        int t[][] = new int[n+1][m+1];
        
        // Initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0) t[i][j] =0;
            }
        }
        
        // Conditions
        int res = 0;   // variable to store max value
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    res = Math.max(res, t[i][j]);
                }
                else{
                    t[i][j] = 0;
                    res = Math.max(res, t[i][j]);
                }
            }
        }

        // Return the maximum value
        return res;

        // NOTE - The Math.max(t[i-1][j-1], 0) doesn't matter because we don't have to return t[n][m]; thus only (t[i][j] = 0;) is enough
    }
}