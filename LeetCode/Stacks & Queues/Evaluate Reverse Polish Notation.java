import java.util.*;
class Solution {
    public int evalRPN(String[] arr) {
        Stack<String> stk = new Stack<>();
        for(String s: arr){
            if(isInteger(s)){
                stk.push(s);
            }else{
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                if(s.equals("+")) stk.push(String.valueOf(b+a));
                else if(s.equals("-")) stk.push(String.valueOf(b-a));
                else if(s.equals("*")) stk.push(String.valueOf(b*a));
                else stk.push(String.valueOf((int)(b/a)));
            }
        }
        return Integer.parseInt(stk.pop());
    }

    // Check if String is an Integer
    public static boolean isInteger(String s){
        try{
            int i = Integer.parseInt(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}