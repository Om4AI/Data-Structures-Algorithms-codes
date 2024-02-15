import java.util.*;

class Solution {
    public long largestPerimeter(int[] arr) {
        int n = arr.length;
        long prefix_sum[] = new long[n];
        long total = 0;

        // Sort to satisfy the elements increasing order condition
        Arrays.sort(arr);

        // Modify prefix sum array
        for (int i=0; i<n; i++){
            total += arr[i];
            prefix_sum[i] = total;
        }

        // Find the maximum perimeter
        for (int i=n-1; i>=2; i--){
            if (arr[i] < prefix_sum[i-1]) return prefix_sum[i];
        }
        return -1;
    }
}