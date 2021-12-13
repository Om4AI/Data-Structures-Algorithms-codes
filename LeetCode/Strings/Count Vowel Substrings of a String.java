import java.util.*;
class Solution {
    public int countVowelSubstrings(String s) {
        List<Character> l = new ArrayList<>();
        l.add('a');
        l.add('e');
        l.add('i');
        l.add('o');
        l.add('u');
        int res = 0;

        for(int i=0; i<=s.length()-5; i++){
            char c = s.charAt(i);
            List<Character> temp = new ArrayList<>(l);
            
            // c is a vowel
            if(l.contains(c)){
                temp.remove(Character.valueOf(c));
                for(int j=i+1; j<s.length(); j++){
                    char t = s.charAt(j);
                    if(l.contains(t)){
                        if(temp.contains(t)){temp.remove(Character.valueOf(t));}
                    }else{
                        break;
                    }
                    if(temp.size()==0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
