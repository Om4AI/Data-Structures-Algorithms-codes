import java.util.*;
class Solution {
    public int findRadius(int[] houses, int[] heaters){
        int res = 0;
        for(int i=0; i<houses.length; i++){
            int min=Integer.MAX_VALUE;
            for(int h: heaters){
                min = Math.min(min, Math.abs(h-houses[i]));
            }
            res = Math.max(res, min);
        }
        return res;
    }
}