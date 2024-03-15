import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] prefix_prod = new int[n];
        int[] suffix_prod = new int[n];

        prefix_prod[0] = 0;
        prefix_prod[1] = arr[0];
        for (int i=2; i<n; i++){
            prefix_prod[i] = prefix_prod[i-1]*arr[i-1];
        }

        suffix_prod[n-1] = 0;
        suffix_prod[n-2] = arr[n-1];
        for (int i=n-3; i>=0; i--){
            suffix_prod[i] = suffix_prod[i+1]*arr[i+1];
        }

        int res[] = new int[n];
        for(int i=1; i<n-1; i++){
            res[i] = prefix_prod[i] * suffix_prod[i];
        }
        res[0] = suffix_prod[0];
        res[n-1] = prefix_prod[n-1];
        return res;
    }
}