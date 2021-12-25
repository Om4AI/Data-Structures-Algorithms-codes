import java.util.*;
class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int b=0, c=0;
        for(int i=0; i<secret.length();i++){
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0)+1);
        }
        
        for(int i=0; i<guess.length(); i++){
            if(secret.charAt(i)==guess.charAt(i)){
                b++;
                map.put(secret.charAt(i), map.get(secret.charAt(i))-1);
            }
        }

        for(int i=0; i<guess.length(); i++){
            char g = guess.charAt(i);
            if(secret.charAt(i)!=g && map.containsKey(g) && map.get(g)>0){
                c++;
                map.put(g, map.get(g)-1);
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(b));
        sb.append("A");
        sb.append(String.valueOf(c));
        sb.append("B");
        
        return sb.toString();
    }
}