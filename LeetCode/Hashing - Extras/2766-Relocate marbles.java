// HashMap approach
import java.util.*;

class Solution {
    public List<Integer> relocateMarbles(int[] arr, int[] moveFrom, int[] moveTo) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int n = arr.length;
        int m = moveFrom.length;
        for (int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (int i=0; i<m; i++){
            int from_el = moveFrom[i];
            int to_el = moveTo[i];
            int count = map.get(from_el);
            map.remove(from_el);
            map.put(to_el, map.getOrDefault(to_el, 0)+count);
        }
        List<Integer> l = new ArrayList<>();
        for (int i:map.keySet()){
            l.add(i);
        }
        return l;
    }
}

// HashSet approach
