import java.util.*;
class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        int i=2;
        String res = "1";
        while(i<=n){
            res = countSay(res);
            i++;
        }
        return res;
    }

    public String countSay(String s){
        int c=1;
        char el = s.charAt(0);
        StringBuffer sb = new StringBuffer();
        for (int i=1; i<s.length(); i++){
            if(s.charAt(i)!=el){
                sb.append(String.valueOf(c));
                sb.append(el);
                c=1;
                el = s.charAt(i);
            }else c++;
        }
        sb.append(String.valueOf(c));
        sb.append(el);
        return sb.toString();
    }
    
    
}
