import java.util.*;

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stk = new Stack<>();
        int max_depth = Integer.MIN_VALUE;

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if (c=='(') stk.push(c);
            else if (c==')'){
                if (!stk.isEmpty() && stk.peek()=='('){
                    stk.pop();
                }else{
                    stk.push(c);
                }
            }

            max_depth = Math.max(max_depth, stk.size());
        }
        return max_depth;
    }
}