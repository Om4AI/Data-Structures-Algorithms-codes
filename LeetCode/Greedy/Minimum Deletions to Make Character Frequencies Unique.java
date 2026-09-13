import java.util.*;

class Solution {
    public int minDeletions(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for(int i=0; i<n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);        
        List<Integer> l = new LinkedList<>();

        for(char k: map.keySet()) l.add(map.get(k));
        Collections.sort(l, (a,b)->(b-a));

        int min = l.get(0)+1, res = 0;
        for(int curr: l){
            if(min==1 || min==0) res+=curr;
            else{
                if(curr<(min-1)) min = curr;
                else min--;
                res+=(curr-min);
            }
        }
        return res;
    }
}