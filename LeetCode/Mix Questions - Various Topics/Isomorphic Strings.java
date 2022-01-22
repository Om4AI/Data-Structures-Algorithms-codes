import java.util.*;
// Code by @Om Mule

class Solution {

    public boolean isIsomorphic(String s, String t) {
        // Analysis:  s & t will always have the same length 
        
        int n = s.length();
        int iso = 1;
        Map<Character, Character> map = new HashMap<Character, Character>();
        Boolean b = true;

        // Loop for actual logic
        for (int i=0; i<n; i++){
            char value = t.charAt(i);
            char key = s.charAt(i);

            // If map doesn't contain value
            if (map.containsValue(value)==false && map.containsKey(key)==false){
                map.put(key, value);
            }
            
            else if (map.containsValue(value)==false && map.containsKey(key)==true){
                iso = 0;
                break;
            }

            // Map already has the value: Check for unique key
            else{
                // System.out.println("Inside Else");
                for (Map.Entry<Character, Character> entry : map.entrySet()){
                    if (entry.getValue() == value){
                        if (entry.getKey() != key){
                            iso = 0;
                            break;
                        }
                    }
                }

                if (iso == 0){
                    break;
                }
            }
        }
        // System.out.println(map);
        if (iso == 0){b = false;}
        return b;
    }
}
