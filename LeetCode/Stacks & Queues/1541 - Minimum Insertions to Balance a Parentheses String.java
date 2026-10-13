import java.util.*;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> stk = new Stack<>();
        boolean almost_balanced = false;
        int count = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='('){
                stk.add(c);
                count += 2;
            }
            else if (c==')'){
                if (!stk.isEmpty() && stk.peek()=='('){
                    stk.add(c);
                    almost_balanced = true;
                    count--;
                }else if (!stk.isEmpty() && stk.peek()==')'){
                    if (almost_balanced==true){
                        stk.pop();
                        stk.pop();
                        count--;
                    }else{
                        stk.add(c);
                        count--;
                    }
                }else{
                    stk.add(c);
                    count += 2;
                }
            }
        }
        System.out.println(stk);
        return count;
    }
}



( ))()()((



( - Add
) - Peek is ( then add & almost_complete = True
    Else if Peek is ) & almost_complete is true -> Remove 3 characters