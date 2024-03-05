import java.util.*;

class Solution {
    public int minimumLength(String s) {
        // Initializations
        int l = 0, r = s.length()-1;
        char curr = 'd';
        
        while(l<r){
            int lcopy = l, rcopy = r;
            
            // Set the current character
            if (s.charAt(l)==s.charAt(r)) curr = s.charAt(l);

            // Modify the left and right indices
            if (s.charAt(l)==curr) l++;
            if (s.charAt(r)==curr) r--;

            // No movement in either of the indices - Encountered distinct characters
            if (lcopy==l && rcopy==r) return r-l+1;
        }

        /*Edge case - Finally both are at the same character and it must be included in either
        the prefix or the suffix */
        if ((l==r) && s.charAt(l)==curr) return 0;
        
        return r-l+1;
    }
}