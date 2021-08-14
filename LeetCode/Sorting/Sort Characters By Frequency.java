// Code by @Om
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int n = s.length();
        List<Character>[] buckets = new List[n+1];
        char chars[] = s.toCharArray();
        // Count Occurences
        for (Character c:chars){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        // Bucket Sort
        for (Character key:map.keySet()){
            int count = map.get(key);
            if (buckets[count] == null){
                buckets[count] = new ArrayList<Character>();
            }
            buckets[count].add(key);
        }

        StringBuffer sb = new StringBuffer();
        for (int i=n; i>0; i--){
            // List of elements: buckets[i]
            if (buckets[i]!=null){
                for (char c:buckets[i]){
                    String t = Character.toString(c);
                    sb.append(t.repeat(i));
                }
            }
        }
        // Create a string
        return sb.toString();
    }
}
