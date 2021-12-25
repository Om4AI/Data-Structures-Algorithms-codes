import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) || Character.isLetter(c)){
                sb.append(c);
            }
        }

        String str = sb.toString();
        str = str.toLowerCase();
        int i=0, j=str.length()-1;
        while(i<str.length() && j>=0){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}