import java.util.*;

class Solution {
    static HashMap<Integer, Integer> map;
    static HashSet<Integer> set;
    static List<Integer> l;
    
    public boolean isNStraightHand(int[] hand, int k){
        
        // Get occurences
        map = new HashMap<>();
        set = new HashSet<>();
        int n = hand.length;
        
        // Base case
        if(n%k!=0) return false;
        
        
        for(int i=0; i<n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
            set.add(hand[i]);
        }

        // Get unique elements
        l = new ArrayList<>(set);
        Collections.sort(l);

        while(l.size()>0){
            // Check if the first K elements can form a group
            if(canFormGroup(k)) continue;
            else return false;
        }
        return true;
    }


    public static boolean canFormGroup(int k){
        if(l.size()<k) return false;
        for(int i=1; i<k; i++){
            if(l.get(i)-l.get(i-1)!=1) return false;
        }

        // Update counts
        for(int i=0; i<k; i++){
            int el = l.get(i), occ = map.get(el);
            if(occ==1){
                map.remove(el);
                l.set(i,-1);
            }
            else map.put(el, occ-1);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i: l){
            if(i!=-1) temp.add(i);
        }
        l = temp;
        return true;
    }
}