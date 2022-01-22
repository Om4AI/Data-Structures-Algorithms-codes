import java.util.*;
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String s[] =  text.split(" ");
        int c = 0;
        for (String l:s){
            int f=1;
            for (int i=0; i<brokenLetters.length(); i++){
                String t = Character.toString(brokenLetters.charAt(i));
                if (l.contains(t)){
                    f=0;
                    break;
                }
            }
            if (f==1){c+=1;}
        }
        return c;
    }
}
