import java.util.*;

// A bit slower to code but faster in execution (Palindrome check with index comparison)
class Solution {
    public static boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public String firstPalindrome(String[] words) {
        for(String word: words){
            if (isPalindrome(word)) return word;
        }
        return "";
    }
}


// Quicker to code but slower in execution (Palindrome check with Stringbuffer)
class Solution {
    public static boolean isPalindrome(String s){
        StringBuffer sb = new StringBuffer(s);
        return s.equals(sb.reverse().toString());
    }


    public String firstPalindrome(String[] words) {
        for(String word: words){
            if (isPalindrome(word)) return word;
        }
        return "";
    }
}


