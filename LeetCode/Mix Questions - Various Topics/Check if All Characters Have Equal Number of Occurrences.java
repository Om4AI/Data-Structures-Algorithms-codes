import java.util.*;

class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashSet<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++){list.add(s.charAt(i));}
        for (int i=0; i<s.length(); i++){set.add(s.charAt(i));}
        HashSet<Integer> occ = new HashSet<>();
        for (Character c: set){
            occ.add(Collections.frequency(list, c));
        }
        return occ.size() ==1;
    }
}
