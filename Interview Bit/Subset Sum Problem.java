public class Solution {
    public int solve(int[] arr, int w){
        int n = arr.length;
        int[][] t = new int[n+1][w+1];

        // Initialization
        for (int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 && j==0) t[i][j] = 1;
                else if(i==0 && j>0) t[i][j] = 0;
                else t[i][j] = 1;
            }
        }

        // Iterative Solution
        for (int i=1; i<n+1; i++){
            for (int j=1; j<w+1; j++){
                if(arr[i-1]<=j){
                    t[i][j] = Math.max(t[i-1][j-arr[i-1]],t[i-1][j]);
                }else t[i][j] = t[i-1][j];
            }
        }
        return t[n][w];
    }
}
