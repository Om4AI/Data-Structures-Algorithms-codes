import java.util.*;
class Solution {
    public String interpret(String cmd) {
        Stack<Character> stk = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<cmd.length(); i++){
            char c = cmd.charAt(i);
            if(c=='G') sb.append("G");
            if(c=='(') stk.push('(');
            if(c==')'){
                if(stk.peek()=='('){
                    stk.pop();
                    sb.append("o");
                }else if(stk.peek()=='l'){
                    stk.pop();
                    stk.pop();
                    stk.pop();
                    sb.append("al");
                }
            }else stk.push(c);
        }
        return sb.toString();   
    }
}