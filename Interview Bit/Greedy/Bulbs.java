import java.util.*;

public class Solution {
    public int bulbs(int[] arr){
        StringBuffer sb = new StringBuffer();
        for(int i: arr) sb.append(String.valueOf(i));
        int n = sb.length();

        // Find the index of the 1st 0
        int index = n;
        for(int i=0; i<n; i++){
            if(sb.charAt(i)=='0'){
                index = i;
                break;
            }
        }

        // Case with all 1s'
        if(index==n) return 0;

        // Count the flips necessary
        int c = 0, el = 0;
        for(int i=index; i<n; i++){
            if(sb.charAt(i)!=el){
                c++;
                el = sb.charAt(i);
            }
        }
        return c;
    }
}
