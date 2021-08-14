// Code by @Om
import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        List<String> buckets[] = new List[words.length+1];

        // Count occurences
        for (String s: words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        // Bucket sort
        for (String key: map.keySet()){
            int occ = map.get(key);
            if (buckets[occ]==null){
                buckets[occ] = new ArrayList<String>();
            }
            buckets[occ].add(key);
        }

        for (int i=0; i<buckets.length; i++){
            if (buckets[i]!=null){
                Collections.sort(buckets[i]);
            }
        }

        // Get most frequent occurrence elements
        List<String> result = new ArrayList<String>();
        for (int i=words.length; i>0; i--){
            if (buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }
        return result.subList(0, k);
    }
}
