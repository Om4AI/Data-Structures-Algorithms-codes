import java.util.*;
class Solution {
    public int numPairsDivisibleBy60(int[] arr) {
        int n = arr.length, c=0;
        // Map to store counts
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int rem = arr[i]%60;
            if(map.containsKey(60-rem)) c+=map.get((60-rem));
            
            // Put remainder and count
            // 0 remainder case
            if(rem==0) map.put(60, map.getOrDefault(60, 0)+1);
            else map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return c;
    }
}