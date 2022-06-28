import java.util.*;

public class Solution{
    public int solve(String s, int b){
        int max = 0, p=0, n = s.length(), curr = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c=='a') curr++;
            p++;
            if(p==b){
                p=0;
                max = Math.max(max,curr);
                curr =0;
            }
        }
        max = Math.max(max,curr);
        return max;
    }
}
