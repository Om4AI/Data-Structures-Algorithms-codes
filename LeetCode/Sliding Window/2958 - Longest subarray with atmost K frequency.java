import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] arr, int k){
        int l = 0, r = 0, n = arr.length;
        int max_len = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        char last_modified = 'l';

        while(r<n && l<=r){
            int curr = arr[r];
            int curr_count = map.getOrDefault(curr, 0);
            if (curr_count<k){
                map.put(curr, curr_count+1);
                r++;
            }else if (curr_count==k){
                max_len = Math.max(max_len, r-l);
                map.put(arr[l], map.get(arr[l])-1);
                l++;
            }
        }
        max_len = Math.max(max_len, r-l);
        return max_len;
    }
}