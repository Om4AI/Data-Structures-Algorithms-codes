import java.util.*;

class Solution{
    static int matrixMultiplication(int n, int arr[]){
        int i=1, j = n-1;
        // Memoization Approach matrix
        int t[][] = new int[n+1][n+1];

        // Initialize
        for(int m=0; m<n+1; m++){
            Arrays.fill(t[m], -1);
        }
        return mcm(arr, t, i, j);
    }

    public static int mcm(int arr[], int t[][], int i, int j){

        // Base condition
        if(i>=j) return 0;

        // Memoization usage
        if(t[i][j]!=-1) return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int tempans = mcm(arr,t,i,k)+mcm(arr,t,k+1,j)+(arr[i-1]*arr[k]*arr[j]);

            min = Math.min(min, tempans);
        }

        return t[i][j] = min;
    }
}