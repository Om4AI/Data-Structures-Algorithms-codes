import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int plen = 0;
        for(Character key: map.keySet()){
            int n = map.get(key);
            int evenocc = (n/2)*2;
            plen+=evenocc;
            map.put(key,map.get(key)-evenocc);
        }

        for (Character key: map.keySet()){
            if(map.get(key)==1){
                plen++;
                break;
            }
        }
        return plen;
    }
}
