import java.util.*;

// --------------------------- Understanding DP better ---------------------------
class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int res = 1, n = arr.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int prev = arr[i]-diff, occ = map.getOrDefault(prev,0)+1;
            map.put(arr[i], occ);
            res = Math.max(res, occ);
        }
        return res;
    }
}
// -------------------------- Store values however you want ---------------------