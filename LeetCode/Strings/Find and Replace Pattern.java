import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] arr, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(matches_pattern(arr[i], pattern)){
                res.add(arr[i]);
            }
        }
        return res;
    }

    public boolean matches_pattern(String s, String p){

        if(s.length()!=p.length()) return false;

        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char wc = s.charAt(i);
            char pc = p.charAt(i);

            // Adding new mapping
            if(!map.containsKey(pc)){
                if(!set.contains(wc)){
                    map.put(pc,wc);
                    set.add(wc);
                }else return false;
            }

            // Matching old mapping
            else if(map.containsKey(pc)){
                if(map.get(pc)!=wc) return false;
            }
        }
        return true;
    }
}