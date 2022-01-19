class Solution {
    public int change(int amt, int[] coins){
        int n = coins.length;
        int t[][] = new int[n+1][amt+1];

        // Initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<amt+1; j++){
                if(amt==0) t[i][j] = 1;
                else if(n==0) t[i][j] = 0;
            }
        }

        // Actual condition loop
        for(int i=1; i<n+1; i++){
            for(int j=1; j<amt+1; j++){
                if(coins[i-1]<=amt){
                    // Include that coin or exclude
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }else t[i][j] = t[i-1][j];
            }
        }
        return t[n][amt];
    }
}