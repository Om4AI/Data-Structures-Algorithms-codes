// Medium: Stack Java Code
// Code by @Om

import java.util.*;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                stk.push('(');
            }else if (!stk.empty() && stk.peek()=='('){
                stk.pop();
            }else if (stk.empty() || stk.peek()==')'){
                stk.push(')');
            }
        }
        return stk.size();
    }
}
