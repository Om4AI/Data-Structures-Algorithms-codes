import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word){
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int n = word.length();
        for (int i=0; i<n; i++){
            char c = word.charAt(i);
            if (!set.contains(c)){
                if (Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))){
                    res++;
                    set.add(Character.toLowerCase(c));
                }else if (Character.isUpperCase(c) && set.contains(Character.toLowerCase(c))){
                    res++;
                    set.add(Character.toUpperCase(c));
                }
            }
            set.add(c);
        }
        return res;
    }
}