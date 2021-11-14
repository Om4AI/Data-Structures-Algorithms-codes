import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        list.add("(");
        list.add(")");  
        HashSet<String> res = new HashSet<>();
        StringBuffer sb = new StringBuffer("(");
        genParentheses(res,list,sb,n);
        return new ArrayList<>(res);
    }
    
    public void genParentheses(HashSet<String> res, List<String> larr, StringBuffer sb, int n){
        // Base Case
        if(sb.length()==n*2){
            if(isValid(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }
        
        // Backtrack & Recursive call
        for(int i=0; i<larr.size(); i++){
            sb.append(larr.get(i));
            genParentheses(res,larr,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==')' && !stk.isEmpty() && stk.peek()=='('){
                stk.pop();
            }else stk.push(c);
            
        }
        return stk.isEmpty();
    }
}
