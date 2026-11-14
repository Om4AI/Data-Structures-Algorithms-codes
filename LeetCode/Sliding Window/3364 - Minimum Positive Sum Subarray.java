import java.util.*;
// Sliding window - For all number between l & r select each number as the size of a sliding window
// Learning - https://app.notion.com/p/DSA-Learnings-4158b8e2f25a8029b12efebaac4839b4?source=copy_link#4188b8e2f25a80b28e89e8a663c79e6d
class Solution {
    public int minimumSumSubarray(List<Integer> arr, int l, int r) {
        int res = Integer.MAX_VALUE, n = arr.size();

        for (int w=l; w<=r; w++){
            int sum = 0;
            // First window of (w) length
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
