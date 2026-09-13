import java.util.*;

class Solution {
    public int maximumSwap(int num){
        
        // Find array of maximums from right
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int n = sb.length(), p=0, index =0;
        int rmax[] = new int[n];
        int maxind[]= new int[n];
        int max = Integer.MIN_VALUE;

        for(int i=n-1; i>=0; i--){
            int curr = Character.getNumericValue(sb.charAt(i));
            if(curr>max){
                max = curr;
                index = i;
            }
            rmax[i] = max;
            maxind[i] = index;
        }

        // Find the numbers to swap
        while(p<n){
            int curr = Character.getNumericValue(sb.charAt(p));
            if(curr<rmax[p]){
                sb.setCharAt(maxind[p], String.valueOf(curr).charAt(0));
                sb.setCharAt(p, String.valueOf(rmax[p]).charAt(0));
                break;
            }
            p++;
        }

        return Integer.parseInt(sb.toString());
    }
}