import java.util.*;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stk = new Stack<>();
        int starCount = 0, leftCount = 0;

        // Fill up the stack
        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if (c=='(') {
                stk.push(c);
                leftCount++;
            }
            else if (c=='*'){
                stk.push(c);
                starCount++;
            }
            else { // c == ')'
                if (stk.isEmpty()){
                    if (starCount==0 && leftCount==0) return false;
                    else{
                        stk.pop();
                        starCount--;
                    }
                }else{
                    // Stack isn't empty
                    if (leftCount>0){
                        // Remove the first left/opening parenthesis
                        boolean found = false;
                        Stack<Character> temp = new Stack<>();
                        while (!found && !stk.isEmpty()){
                            Character t = stk.pop();
                            if (t=='('){
                                found = true;
                                leftCount--;
                            }else if (t=='*'){
                                temp.push(t);
                            }
                        }
                        while (!temp.isEmpty()){
                            stk.push(temp.pop());
                        }
                    }else{
                        // Stack isn't empty & leftCount==0 means stack only has star/stars
                        stk.pop();
                        starCount--;
                    }
                }
            }
        }
        // Basic result cases
        if (stk.isEmpty()) return true;
        else if (stk.peek()=='(') return false;

        int stars = 0;
        while (!stk.isEmpty()){
            char top = stk.pop();
            if (top=='*') stars++;
            else if (top=='('){
                // Means there is no matching * for that (
                if (stars==0) return false;
                stars--;
            }
        }
        return true;
    }
}