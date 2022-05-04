// Brute Force - Using ArrayList (TLE)
import java.util.*;
class Solution {
    public int maxOperations(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        int c = 0;
        for(int i: nums){
            if(l.contains(i)){
                l.remove(l.indexOf(i));
                c++;
            }else l.add(k-i);
        }
        return c;
    }
}


// Optimized approach - Using HashMaps (Accepted)
class Solution {
    public int maxOperations(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int c = 0;
        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+1);
        
        for(int k: map.keySet()){
            int d = target-k;
            if(d==k){
                c+=map.get(k)/2;
                continue;
            }
            if(map.containsKey(d)){
                int min=Math.min(map.get(k), map.get(d));
                c+=min;
                map.put(d,0);
            }
        }
        return c;
    }
}