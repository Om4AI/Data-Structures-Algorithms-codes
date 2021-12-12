import java.util.*;
class Solution {
    public String removeOccurrences(String s, String part){
        while(substr_present(s,part)){
            s = remove_substr(s,part);
        }
        return s;   
    }

    public boolean substr_present(String s, String p){
        for(int i=0; i<=s.length()-p.length(); i++){
            if(p.equals(s.substring(i, i+p.length()))) return true;
        }
        return false;
    }

    public String remove_substr(String s, String p){
        StringBuffer sb = new StringBuffer();
        int slen = s.length();
        int plen = p.length(), i=0;
        for(i=0; i<=slen-plen; i++){
            String substr = s.substring(i, i+plen);
            if(substr.equals(p))
                break;
        }
        
        for(int j=0; j<i; j++){
            sb.append(s.charAt(j));
        }
        for(int j=i+plen; j<slen; j++){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
