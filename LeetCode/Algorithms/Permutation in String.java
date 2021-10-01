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

// More optimized solution
import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int win_size = s1.length(), i=0;
        int j=0+win_size-1;
        
        if (s2.length()<s1.length()) return false;
        
        // Create a map for s1
        HashMap<Character, Integer> ms1 = new HashMap<>();
        for (int k=0; k<s1.length(); k++){
            ms1.put(s1.charAt(k), ms1.getOrDefault(s1.charAt(k), 0)+1);
        }
        
        // Actual loop
        HashMap<Character, Integer> t = new HashMap<>();
        for (int k=i; k<=j; k++) t.put(s2.charAt(k), t.getOrDefault(s2.charAt(k), 0)+1);
        
        
        while(j<s2.length()){
            if (ms1.equals(t)) return true;
            else if (j!=s2.length()-1){
                Character fc = s2.charAt(i);
                if (t.get(fc)==1){
                    t.remove(fc);
                    i++;
                    j++;
                    t.put(s2.charAt(j), t.getOrDefault(s2.charAt(j), 0)+1);
                }else{
                    t.put(fc, t.get(fc)-1);
                    i++;
                    j++;
                    t.put(s2.charAt(j), t.getOrDefault(s2.charAt(j), 0)+1);
                }
            }else return false;
        }
        return false;
    }
}
