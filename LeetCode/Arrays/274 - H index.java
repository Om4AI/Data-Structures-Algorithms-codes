import java.util.*;

class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            max = Math.max(max, Math.min(arr[i], n-i));
        }
        return max;
    }
}