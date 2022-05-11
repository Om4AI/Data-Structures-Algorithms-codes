import java.util.*;
public class Solution {
    public int solve(int[] arr){
        Arrays.sort(arr);
        int n = arr.length,t=0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
            set.add(i);
        }

        int occ[] = new int[set.size()];
        List<Integer> l = new ArrayList<>(set);
        Collections.sort(l);
        occ[l.size()-1]=0;
        for(int i=l.size()-2; i>=0; i--){
            occ[i] = occ[i+1]+map.get(l.get(i+1));
        }

        for(int i=0; i<occ.length; i++){
            if(l.get(i)==occ[i]) return 1;
        }

        return -1;
    }
}
