// Brute Force - O(n^2) solution
import java.util.*;
class Solution {
    public int maxSubArray(int[] arr) {
        int sum = Integer.MIN_VALUE, n = arr.length;
        for (int i=0; i<n-1; i++){
            int tsum = arr[i], temp = arr[i];
            for (int j=i+1; j<n; j++){
                temp+=arr[j];
                tsum = Math.max(tsum, temp);
            }
            sum = Math.max(sum, tsum);
        }
        return Math.max(sum, arr[n-1]);
    }
}

// Linear runtime O(n) solution
import java.util.*;
class Solution {
    public int maxSubArray(int[] arr) {
        int max_sum = arr[0], curr_sum = arr[0];
        for (int i=1; i<arr.length; i++){
            curr_sum = Math.max(curr_sum+arr[i], arr[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}
