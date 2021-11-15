// Brute Force

import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        if(isPalindrome(s)) return s;

        String longest = "";
        for (int i=0; i<s.length(); i++){
            for (int j=1; j<=s.length()-i; j++){
                String str = s.substring(i,i+j);
                if(isPalindrome(str) && str.length()>longest.length()) longest = str;
            }
        }
        return longest;
    }

    public boolean isPalindrome(String s){
        int f = 1, i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)){
                f = 0;
                break;
            }
            i++;
            j--;
        }
        return f==1;
    }
}


// Optimized O(n^2)

import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        if(isPalindrome(s)) return s;

        String longest = "";
        for (int i=0; i<s.length(); i++){
            for (int j=1; j<=s.length()-i; j++){
                String str = s.substring(i,i+j);
                if(isPalindrome(str) && str.length()>longest.length()) longest = str;
            }
        }
        return longest;
    }

    public boolean isPalindrome(String s){
        int f = 1, i=0, j=s.length()-1;
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)){
                f = 0;
                break;
            }
            i++;
            j--;
        }
        return f==1;
    }
}

