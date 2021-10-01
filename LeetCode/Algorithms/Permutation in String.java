// Not optimized - Using Hashmaps
import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int win_size = s1.length(), i=0;
        int j=0+win_size;
        // Create a list for s1
        HashMap<Character, Integer> ms1 = new HashMap<>();
        for (int k=0; k<s1.length(); k++){
            ms1.put(s1.charAt(k), ms1.getOrDefault(s1.charAt(k), 0)+1);
        }
        // Actual loop
        while(j<=s2.length() && i<j){
            HashMap<Character, Integer> t = new HashMap<>();
            for (int k=i; k<j; k++) t.put(s2.charAt(k), t.getOrDefault(s2.charAt(k), 0)+1);
            if (ms1.equals(t)) return true;
            else{
                i++;
                j++;
            }
        }
        return false;
    }
}
