class Solution{
    public int cutRod(int price[], int n){
        int len = price.length;
        int rod_lens[] = new int[len];

        // Initialize rod lengths
        for(int i=0; i<len; i++) rod_lens[i] = i+1;

        // Bottom Up Approach Matrix
        int t[][] = new int[len+1][n+1];
        // Initialization
        for(int i=0; i<len+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        // Actual logic conditions
        for(int i=1; i<len+1; i++){
            for(int j=1; j<n+1; j++){
                if(rod_lens[i-1]<=j){
                    t[i][j] = Math.max((price[i-1]+t[i][j-rod_lens[i-1]]), t[i-1][j]);
                }else t[i][j] = t[i-1][j];
            }
        }
        return t[len][n];
    }
}