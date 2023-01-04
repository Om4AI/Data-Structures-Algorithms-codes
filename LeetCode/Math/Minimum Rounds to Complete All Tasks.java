import java.util.*;
class Solution {
    public int minimumRounds(int[] tasks){
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0; 

        // Get counts
        for(int i: tasks) map.put(i, map.getOrDefault(i, 0)+1);

        // Get the counts and result 
        for(int k: map.keySet()){
            int c = map.get(k);
            if(c==1) return -1;
            else if(c%3==0) res+=(c/3);
            else{
                // If case1: Remainder=1: (x-1)(3 pair) + 2(2 pairs)
                // Else case2: Remainder=2: x(3 pair) + 1(2 pair)
                res+=((c/3)+1); // Both conditions same value
            }
        }
        return res;
    }
}