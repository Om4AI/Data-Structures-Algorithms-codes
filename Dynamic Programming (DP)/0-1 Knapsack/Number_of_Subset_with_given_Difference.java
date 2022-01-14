import java.util.*;

// Code by @Om
public class Number_of_Subset_with_given_Difference {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3};
        int diff = 1;
        System.out.println(count_subset_with_given_diff(arr, diff));
    }

    public static int count_subset_with_given_diff(int[] arr, int diff){
        // Sum of array
        int sum = 0, n=arr.length;
        for(int i: arr)sum+=i;

        // Calculate sum of subset
        int s1 = (sum+diff)/2;

        // Count of subset sum
        return count_of_subset_sum(arr, n, s1);
    }

    // This function takes - set of numbers(arr) & sum value
    // Returns - Number of subsets that have that sum
    public static int count_of_subset_sum(int[] arr, int n, int sum){
        int t[][] = new int[n+1][sum+1];

        // Initialization - Number of subsets
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(j==0) t[i][j] = 1;
                else if (n==0 && j>0) t[i][j] = 0;
            }
        }

        // Conditions loop
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    // Consider both the cases of inclusion & exclusion
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
