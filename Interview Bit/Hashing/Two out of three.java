import java.util.*;

public class Solution {
    public int[] solve(int[] A, int[] B, int[] C){
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();


        for(int i: A) set.add(i);
        List<Integer> t = new ArrayList<>(set);
        for(int i: t) map.put(i, map.getOrDefault(i, 0)+1);
        set = new HashSet<>();


        for(int i: B) set.add(i);
        t = new ArrayList<>(set);
        for(int i: t) map.put(i, map.getOrDefault(i, 0)+1);
        set = new HashSet<>();

        for(int i: C) set.add(i);
        t = new ArrayList<>(set);
        for(int i: t) map.put(i, map.getOrDefault(i, 0)+1);


        List<Integer> l = new ArrayList<>();
        for(int k: map.keySet()) {
            if(map.get(k)>=2) l.add(k);
        }
        Collections.sort(l);

        int res[] = new int[l.size()];
        for(int i=0; i<l.size(); i++) res[i] = l.get(i);
        return res;
    }
}
