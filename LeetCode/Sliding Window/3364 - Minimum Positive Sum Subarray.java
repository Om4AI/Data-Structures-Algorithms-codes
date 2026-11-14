import java.util.*;

// Sliding window - For all number between l & r select each number as the size of a sliding window
class Solution {
    public int minimumSumSubarray(List<Integer> arr, int l, int r) {
        int res = Integer.MAX_VALUE, n = arr.size();

        for (int w=l; w<=r; w++){
            int sum = 0;
            // First window os this length
            for (int i=0; i<w; i++){
                sum+=arr.get(i);
            }

            if (sum>0) res = Math.min(res, sum);
            for (int j=w; j<n; j++){
                sum += arr.get(j) - arr.get(j-w);
                if (sum>0) res = Math.min(res, sum);
            }
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }
}
