class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int t[][] = new int[n+1][amt+1];
        
        // Initializations
        // Init - 1
        for(int i=0; i<n+1; i++){
            for(int j=0; j<amt+1; j++){
                if(i==0) t[i][j] = Integer.MAX_VALUE-1;
                else if(j==0) t[i][j] = 0;
            }
        }

        // Init - 2
        for(int j=1; j<amt+1; j++){
            if(j%coins[0]==0) t[1][j] = j/coins[0];
            else t[1][j] = Integer.MAX_VALUE-1;
        }

        // Actual logic loop
        for(int i=2; i<n+1; i++){
            for(int j=1; j<amt+1; j++){
                if(coins[i-1]<=j){
                    // Min from if u include or exclude that coin
                    // Adding (1 + t[i][j-coins[i-1]])(Inclusion Case) is important
                    t[i][j] = Math.min(t[i][j-coins[i-1]]+1, t[i-1][j]);
                }else t[i][j] = t[i-1][j];
            }
        }

        // According to Leetcode Question
        if(t[n][amt]==Integer.MAX_VALUE-1) return -1;
        else return t[n][amt];
    }
}