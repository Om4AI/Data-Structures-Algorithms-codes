import java.util.*;

public class Solution {
    public int solve(String s){
        Stack<Character> stk = new Stack<>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='('){
                stk.push(c);
            }else{
                // If stack is empty
                if (stk.isEmpty()){
                    stk.push(c);
                }else{
                    if (stk.peek()=='(') stk.pop();
                    else stk.push(c);
                }
            }
        }

        return stk.size();
    }
}
