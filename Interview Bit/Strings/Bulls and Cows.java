import java.util.*;

class Solution {
    public String solve(String s, String g) {
        StringBuffer sec = new StringBuffer();
        StringBuffer gue = new StringBuffer();
        int bulls = 0, cows = 0;

        // Buuls count
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==g.charAt(i)){
                bulls++;
                sec.append('c');
                gue.append('c');
            }else{
                sec.append(s.charAt(i));
                gue.append(g.charAt(i));
            }
        }
        s = sec.toString();
        g = gue.toString();

        // Count the letters
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='c'){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            }
        }

        // Cows count
        for(int i=0; i<g.length(); i++){
            char c = g.charAt(i);
            if(map.containsKey(c)){
                cows++;
                int count = map.get(c);
                count--;

                // Count non-zero
                if(count>0) map.put(c,count);
                // Count zero
                if(count==0) map.remove(c);
            }
        }
        StringBuffer res = new StringBuffer();
        res.append(bulls);
        res.append("A");
        res.append(cows);
        res.append("B");
        return res.toString();
    }
}