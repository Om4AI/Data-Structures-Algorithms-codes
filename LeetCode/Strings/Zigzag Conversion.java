import java.util.*;
class Solution {
    public String convert(String str, int n){
        
        // Single row case - No change in String
        if(n==1) return str;
        
        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<Character>());

        int p = 0, g=1, s=0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            // Execute the loop for back and forth movement
            if(p==n-1 & g==1){
                List<Character> l = new ArrayList<>();
                l.addAll(list.get(p));
                l.add(c);
                list.set(p, l);
                g=0;
                s=1;
            }else if(p==0 && s==1){
                List<Character> l = new ArrayList<>();
                l.addAll(list.get(p));
                l.add(c);
                list.set(p, l);
                s=0;
                g=1;
            }else{
                List<Character> l = new ArrayList<>();
                l.addAll(list.get(p));
                l.add(c);
                list.set(p, l);
            }

            // Increment and Decrement Counter
            if(s==1) p--;
            else if(g==1) p++;
        }

        // Create final string
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<list.size(); i++){
            List<Character> l = list.get(i);
            for(char c:l)sb.append(c);
        }
        return sb.toString();
    }
}