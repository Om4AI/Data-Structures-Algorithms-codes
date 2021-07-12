import java.util.*;

// Code by @Om Mule

class Solution {

    public boolean isIsomorphic(String s, String t) {
        // Analysis:  s & t will always have the same length 
        
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        int iso = 1;
        Map<Character, Character> map = new HashMap<Character, Character>();

        // Loop for actual logic
        for (int i=0; i<n; i++){
            char value = t.charAt(i);
            char key = s.charAt(i);

            // Key absent in map
            if (map.get(key) == null){
                if (map.containsValue(value) == true){
                    iso = 0;
                    break;
                }
                else{
                    map.put(key, value);
                    sb.append(value);
                }

            }

            // Key present in map
            else{
                sb.append(map.get(key));
            }
            
        }
        if (sb.toString().equals(t) == false){iso = 0;}
        if (iso == 0){return false;}
        else{return true;}        
    }
}
