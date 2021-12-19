import java.util.*;
class Solution {
    public char findTheDifference(String s, String t){
        char[] t1 = s.toCharArray();
        Arrays.sort(t1);
        s = String.valueOf(t1);

        char[] t2 = t.toCharArray();
        Arrays.sort(t2);
        t = String.valueOf(t2);

        if(s.length()<=t.length()){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=t.charAt(i)){
                    return t.charAt(i);
                }
            }
            return t.charAt(t.length()-1);
        }else if(t.length()<s.length()){
            for(int i=0; i<t.length(); i++){
                if(s.charAt(i)!=t.charAt(i)){
                    return s.charAt(i);
                }
            }
            return s.charAt(s.length()-1);
        }
        return 'a';
    }
}