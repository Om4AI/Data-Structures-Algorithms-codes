class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        int n = s.length();
        char el, top;
        int i =0, f=1;
        while (i<n && n>1){
            el = s.charAt(i);
            if ((el == ')' || el =='}' || el==']')&& stk.empty()==false){
                top = stk.peek();
                if ((el==')' && top=='(')|| (el==']' && top=='[')|| (el=='}' && top=='{')){
                    stk.pop();
                }
                else{f=0;}
            }
            else{
                stk.push(el);
            }
            i+=1;
        }
        if (stk.empty()==false || n==1 || f==0){return false;}
        else{return true;}
    }       
}
