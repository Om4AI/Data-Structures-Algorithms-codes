import java.util.*;

// GFG Link - https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
class Solution {
    public int minDifference(int[] arr, int n) {
        int range = 0;
        for(int i: arr) range+=i;
        boolean ss[][]= subsetSum(arr, range);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=range; i++){
            if(ss[n][i]==true){
                min = Math.min(min, Math.abs(range-(2*i)));
            }
        }
        return min;
    }

    public boolean[][] subsetSum(int[] arr, int w){
        int n = arr.length;
        boolean t[][] = new boolean[n+1][w+1];

        // Initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(j==0) t[i][j] = true;
                else if(i==0 & j>0) t[i][j] = false;
            }
        }

        // Subset Sum Calculation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(arr[i-1]<=j){
                    t[i][j] = (t[i-1][j-arr[i-1]])||t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t;
    }
}