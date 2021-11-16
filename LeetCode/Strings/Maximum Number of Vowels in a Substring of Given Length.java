import java.util.*;

// SLIDING WINDOW PROTOCOL
class Solution {
    public int maxVowels(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int p=0, max=Integer.MIN_VALUE;
        for (p=0; p<k; p++) sb.append(s.charAt(p));
        int count = getVowels(sb.toString());

        max = Math.max(max, count);

        // MAIN LOOP 
        while(p<s.length()){
            if(isVowel(sb.charAt(0))) count--;
            sb.deleteCharAt(0);
            if(isVowel(s.charAt(p))) count++;
            sb.append(s.charAt(p));
            p++;
            max = Math.max(max, count);
        }
        return max;
    }

    // Check if a character is a vowel or not
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }

    // Count the number of vowels in the String
    public int getVowels(String s){
        int count = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') count++;
        }
        return count;
    }
}
