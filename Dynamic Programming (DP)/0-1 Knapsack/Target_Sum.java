import java.util.*;

class Solution {
    public int findTargetSumWays(int[] arr, int target){
        // Remove cases like [0,0,1,0,0]
        Arrays.sort(arr);

        int sum = 0;
        // Sum of all array elements
        for(int i:arr) sum+=i;

        // Edge cases
        if(target>sum || (target+sum)%2!=0 || (target+sum)<0) return 0;
        
        // Decimal handling
        int s1 = (int)Math.ceil((double)(sum+target)/2);

        // Handling 0s'
        int zp =0;
        for(int i:arr) if(i==0) zp++;

        // Call the Count of Subset Sum
        return count_subset_sum(arr, arr.length, s1,zp);
    }

    // Count of Subsets whose sum = s1
    public static int count_subset_sum(int[] arr,int n, int s1, int zp){
        int t[][] = new int[n+1][s1+1];
        // Initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<s1+1; j++){
                if(j==0) t[i][j] = 1;
                else if(i==0 && j>0) t[i][j] = 0;
            }
        }

        // Conditions of inclusion & exclusion
        for(int i=1; i<n+1; i++){
            for(int j=1; j<s1+1; j++){
                if(arr[i-1]<=j){
                    // Include or exclude the element
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else if(arr[i-1]>j || arr[i-1]==0){
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // Multiply the result with 2s' power of number of 0s'
        return (int)Math.pow(2, zp)*t[n][s1];
    }
}