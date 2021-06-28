import java.util.*;
import java.io.*;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if (stk.isEmpty()){stk.push(s.charAt(i));}
            else{
                char c = stk.peek();
                if (s.charAt(i)==c){stk.pop();}
                else{stk.push(s.charAt(i));}
            }
            
        }
        StringBuffer sb = new StringBuffer();
        while(stk.isEmpty()==false){
            char c = stk.pop();
            sb.append(c);
        }
        sb.reverse();
        String r = sb.toString();
        return r;
    }
}
