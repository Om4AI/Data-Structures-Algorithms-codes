import java.util.*;

class Index_Occ{
    int index;
    int occurence;

    Index_Occ(int index, int occ){
        this.index = index;
        occurence = occ;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Index_Occ> map = new HashMap<>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // Character entry exists
            if (map.containsKey(c)){
                Index_Occ temp = map.get(c);
                temp.occurence += 1;
                map.put(c, temp);
            }
            // Entry isn't present
            else{
                Index_Occ obj = new Index_Occ(i, 1);
                map.put(c, obj);
            }
        }

        // Check whichever first index has occurence = 1
        int min_index = Integer.MAX_VALUE;
        for (char c: map.keySet()){
            Index_Occ temp = map.get(c);
            if (temp.occurence==1){
                min_index = Math.min(min_index, temp.index);
            }
        }
        return min_index==Integer.MAX_VALUE? -1:min_index;
    }
}