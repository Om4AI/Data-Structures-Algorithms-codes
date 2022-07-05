import java.util.*;

// ------------------ HashMap of HashMaps approach -------------------
class Solution {
    public int longestArithSeqLength(int[] arr) {
        // {index: {diff: count}}
        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();
        int n = arr.length;

        // Fill the HashMap<> & get the result
        int res = 0;
        for(int i=0; i<n; i++){
            map.put(i, new HashMap<>());
            for(int j=0; j<i; j++){
                // Current - previous
                int diff = arr[i]-arr[j];
                int tcount = map.get(j).getOrDefault(diff, 0)+1;
                
                map.put(i, map.get(i).put(diff,tcount));
                res = Math.max(res,tcount);
            }
        }
        return res;
    }
}

// ------------------ Array of HashMaps --------------------------------
class Solution {
    public int longestArithSeqLength(int[] arr){
        int n = arr.length, ans = 1;
        HashMap<Integer,Integer> res[] = new HashMap[n];

        // Fill up the HashMaps for every element
        for(int i=0; i<n; i++){
            int curr = arr[i];
            res[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                int prev = arr[j];
                int diff = curr-prev;
                int diff_count = res[j].getOrDefault(diff,0)+1;
                HashMap<Integer, Integer> temp = res[i];
                
                temp.put(diff,diff_count);
                res[i] = temp;
                ans = Math.max(ans,diff_count);
            }
        }
        return ++ans;
    }
}