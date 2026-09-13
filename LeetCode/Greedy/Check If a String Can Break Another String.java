import java.util.*;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        // Sort the character arrays
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray();
        int n = c2.length, index = 0;
        Arrays.sort(c1);
        Arrays.sort(c2);

        // Find the first distinct character
        for(int i=0; i<n; i++){
            if(c1[i]!=c2[i]){
                index = i;
                break;
            }
        }
        
        // Check for breaking
        int dominant = c1[index]>c2[index]? 1: 2;
        for(int i=index; i<n; i++){
            int td = c1[i]>c2[i]? 1: 2;
            if(dominant!=td && c1[i]!=c2[i]){
                return false;
            }
        }
        return true;
    }
}