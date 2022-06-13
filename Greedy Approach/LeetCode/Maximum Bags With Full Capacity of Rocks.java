import java.util.*;
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length, p=0,c=0;
        
        // Create differences array
        int diff[] = new int[n];
        for(int i=0; i<n; i++) diff[i] = capacity[i] - rocks[i];

        // Sort differences
        Arrays.sort(diff);
        while(p<n && additionalRocks>0){
            if(diff[p]<=additionalRocks){
                c++;
                additionalRocks-=diff[p];
            }else{
                return c;
            }
            p++;
        }
        return c;
    }
}