import java.util.*;
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return createStr(s).equals(createStr(t));
    }

    public static String createStr(String s){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='#'){
                if(!stk.isEmpty()) stk.pop();
            }else stk.push(c);
        }

        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.toString();
    }
}