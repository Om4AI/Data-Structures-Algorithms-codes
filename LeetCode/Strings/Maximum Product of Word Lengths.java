import java.util.*;

class Solution {
    public int maxProduct(String[] words) {
        // Nested FOR Loop for getting valid pairs
        int res = 0, n = words.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(check_comp(words[i], words[j])){
                    res = Math.max(res, (words[i].length() * words[j].length()));
                }
            }
        }
        return res;
    }

    public boolean check_comp(String a, String b){

        // Check if any letter is common in both the strings
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            if(b.contains(String.valueOf(c))) return false;
        }
        return true;
    }
}