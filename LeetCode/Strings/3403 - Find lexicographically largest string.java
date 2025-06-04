import java.util.*;
class Solution {
    public String answerString(String word, int numFriends) {
        int max_ascii = 0;
        int n = word.length();
        int win_len = n - (numFriends-1);
        // Edge case
        if (numFriends == 1){
            return word;
        }

        for (int i=0; i<n; i++){
            max_ascii = Math.max(max_ascii, (int)word.charAt(i));
        }
        char max_char = (char)max_ascii;

        List<String> l = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (word.charAt(i) == max_char){
                if ((i+win_len) > n){
                    l.add(word.substring(i, n));
                }
                else {l.add(word.substring(i, i+win_len));}
            }
        }
        Collections.sort(l);
        return l.get(l.size()-1);
    }
}