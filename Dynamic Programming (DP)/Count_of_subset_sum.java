class Solution{
	public int perfectSum(int arr[],int n, int w){
        int t[][] = new int[n+1][w+1];

        // Initialization
        for (int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(j==0) t[i][j] = 1;
                else if(i==0 && j>0) t[i][j] = 0;
            }
        }

        // Iterative knapsack code
        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                // Conditions - (Element<=W) && (Element>W)
                if(arr[i-1]<=j){
                    // Store t[i][j] = Include count + Exclude count
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }else t[i][j] = t[i-1][j];
            }
        }
        return t[n][w]%(1000000007);
    } 
}