public class Solution {
    public int solve(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stk.isEmpty() && c==')') return 0;
            else if (c=='(') stk.push(c);
            else if(c==')' && stk.peek()=='(') stk.pop();
        }
        return stk.isEmpty()? 1:0;
    }
}
