import java.util.*;

class MapSum {
    private HashMap<String, Integer> map = new HashMap<>();
    
    public void insert(String key, int val) {
        map.put(key, val); 
    }
    
    public int sum(String prefix) {
        int sum =0;
        for (String s:map.keySet()){
            int f = 1;
            if (prefix.length() > s.length()) {f = 0;}
            else{
                for(int i=0; i<prefix.length(); i++){
                    if (s.charAt(i)!=prefix.charAt(i)) {f = 0;}
                }
                if (f==1){ sum += map.get(s);}
            }
        }
        return sum;
    }
}
