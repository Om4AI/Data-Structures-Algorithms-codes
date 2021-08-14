// Code by @Om
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> buckets[] = new List[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Count occurences
        for (int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        // Put the frequencies into buckets
        for (int key: map.keySet()){
            int val = map.get(key);
            if (buckets[val]==null){
                buckets[val] = new ArrayList<Integer>();
            }
            buckets[val].add(key);
        }
        // Add elements into list
        List<Integer> l = new ArrayList<Integer>();
        int res[] = new int[k];
        for (int i=nums.length; i>0; i--){
            if (buckets[i] != null){
                l.addAll(buckets[i]);
            }
        }
        // Fetch top K elements
        for (int i=0; i<k; i++){
            res[i] = l.get(i);
        }
        return res;
    }
}
