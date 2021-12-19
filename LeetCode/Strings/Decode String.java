import java.util.*;
class Solution {
    public String decodeString(String s){

        StringBuffer sb = new StringBuffer();

        // Parser Loop
        while(isNotValid(s)){
            StringBuffer num = new StringBuffer();
            for(int i=0; i<s.length(); i++){

                char c = s.charAt(i);
                // Loop to get the occurence count
                if(Character.isDigit(c)){

                    num.setLength(0);

                    // Get the full number
                    char tempc = s.charAt(i);
                    while(Character.isDigit(tempc)){
                        num.append(tempc);
                        i++;
                        tempc = s.charAt(i);
                    }
                    // Decrement i because it will get incremented at the start of loop
                    i--;
                    continue;
                }

                // Get the further letters to be repeated
                if(c=='['){
    
                    StringBuffer innersb = new StringBuffer();
                    // Occurence number found
                    int occ = Integer.valueOf(num.toString());
    
                    // Start getting the string inside the bracket
                    Stack<Character> stk = new Stack<>();
                    int p = i;
                    stk.push(s.charAt(p));
                    p++;
                    while(!stk.isEmpty()){
                        char temp = s.charAt(p);
                        innersb.append(temp);
    
                        if(temp==']' && stk.peek()=='[') stk.pop();
                        else if(temp=='[') stk.push(temp);
                        p++;
                    }
                    i=p-1;
                    innersb.deleteCharAt(innersb.length()-1);
                    sb.append(innersb.toString().repeat(occ));
                }else sb.append(c);
            }
            // Modify string s
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }

    public boolean isNotValid(String s){
        if(s.contains("[") || s.contains("]")) return true;
        return false;
    }
}