import java.util.*;

// Two pointers - First find the values of max (0..i) & min from right (n-1..i)
// These values need to be stored in score arrays which would be used later to find the instability score
class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE, n = arr.length;
        int[] left_scores = new int[n];
        int[] right_scores = new int[n];
        for (int i=0; i<n; i++){
            left = Math.max(left, arr[i]);
            left_scores[i] = left;
        }
        for (int i=n-1; i>=0; i--){
            right = Math.min(right, arr[i]);
            right_scores[i] = right;
        }

        // Actual loop to check instability score (min-max)<=k
        for (int i=0; i<n; i++){
            if ((left_scores[i]-right_scores[i])<=k) return i;
        }
        return -1;
    }
}