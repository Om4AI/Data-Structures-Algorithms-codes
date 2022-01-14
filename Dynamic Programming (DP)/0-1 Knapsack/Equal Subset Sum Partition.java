// Code by Om
import java.util.*;
class Solution {
    public boolean canPartition(int[] arr){
        int sum = 0;
        for(int num: arr)sum+=num;

        // Equal partition of total sum - not possible
        if(sum % 2!=0) return false;

        // Even sum - Target(w) for subset creation
        int w = sum/2;

        return subset_sum(arr,arr.length,w);
    }

    public boolean subset_sum(int[] arr, int n, int w){
        boolean[][] t = new boolean[n+1][w+1];

        // Initialization
        for (int i=0; i<n+1; i++){
            for (int j=0; j<w+1; j++){
                if(i==0 && j==0) t[i][j] = true;
                else if(i==0 && j>0) t[i][j] = false;
                else t[i][j] = true;
            }
        }

        // Iterative knapsack function
        for (int i=1; i<n+1; i++){
            for (int j=1; j<w+1; j++){
                if(arr[i-1]<=j){
                    // OR between - SELECT number & UNSELECT number
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else t[i][j] = t[i-1][j];
            }
        }

        return t[n][w];
    }
}
