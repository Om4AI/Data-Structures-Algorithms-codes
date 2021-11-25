import java.util.*;
class Solution{
    static boolean isSubsetSum(int n, int[] arr, int w){
        boolean[][] t = new boolean[n+1][w+1];

        // Initialization
        for(int i=0; i<n+1; i++){
            for (int j=0;j<w+1; j++){
                if(i==0 && j==0) t[i][j] = true;
                else if(i==0 && j>0) t[i][j] = false;
                else t[i][j] = true;
            }
        }

        // Iterative code
        for (int i=1; i<n+1; i++){
            for (int j=1; j<w+1; j++){
                // For boolean use bitwise OR operation 
                if(arr[i-1]<=j){
                    t[i][j] = (t[i-1][j-arr[i-1]]) || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}