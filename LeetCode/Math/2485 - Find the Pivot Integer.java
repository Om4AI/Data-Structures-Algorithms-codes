import java.util.*;

class Solution {
    public int pivotInteger(int n) {
        int[] prefix_sum = new int[n];
        int[] suffix_sum = new int[n];

        prefix_sum[0] = 1;
        suffix_sum[n-1] = n;
        for (int i=1; i<n; i++){
            prefix_sum[i] = prefix_sum[i-1]+i+1;
        }

        for (int i=n-2; i>=0; i--){
            suffix_sum[i] = suffix_sum[i+1]+i+1;
        }

        for (int i=0; i<n; i++){
            if (prefix_sum[i]==suffix_sum[i]) return i+1;
        }
        return -1;
    }
}