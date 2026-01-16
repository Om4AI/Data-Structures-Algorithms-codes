import java.util.*;

class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid_el = arr[n/2];

        int res = 0;
        for (int i=0; i<n; i++){
            res += Math.abs(arr[i] - mid_el);
        }
        return res;
    }
}
