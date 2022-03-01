// Redundant Braces - Java Code
public class Solution {
    public int braces(String s){
        Stack<Character> stk = new Stack<>();
        
        // Condition to check (a) type cases
        for(int i=1; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(s.charAt(i-1)=='(' && s.charAt(i+1)==')') return 1;
        }

        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);

            // Conditions
            if(c=='(') stk.push(c);
            // IMP - Empty stack condition
            else if(c!='(' && c!=')' && stk.isEmpty()) stk.push(c);
            else if (c!='(' && c!=')' && stk.peek()!='c') stk.push('c');
            else if (c==')' && stk.peek()=='('){
                return 1;
            }
            else if(c==')' && stk.peek()=='c'){
                stk.pop();
                stk.pop();
            }
        }
        return 0;
    }
}
