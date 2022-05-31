import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> prev = new HashMap<>();
        HashMap<Integer,Integer> mins = new HashMap<>();

        int min = Integer.MAX_VALUE;

        for(int i=0; i<cards.length; i++){
            int num = cards[i];
            
            if(prev.containsKey(num)){
                int diff = i-prev.get(num)+1;
                if(mins.containsKey(num)){
                    int t = mins.get(num);
                    t= Math.min(t, diff);
                    mins.put(num,t);
                    min = Math.min(t,min);
                }else{
                    mins.put(num, diff);
                    min = Math.min(diff,min);
                }
                prev.put(num,i);
            }else{
                prev.put(num,i);
            }
        }

        
        return (min==Integer.MAX_VALUE)?-1:min;
    }
}