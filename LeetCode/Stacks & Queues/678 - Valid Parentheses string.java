import java.util.*;

// Stack + Greedy approach (we perform the best move at the current instance)
// Approach -
// 1. Add the characters in the stack ("(" & "*")
// 2. When we get a ")" character, we remove the first instance of "(" or if inexistent then remove the first "*"
// 3. For knowing if we have the required character to be removed, we maintain 2 counts - leftCount("(") & starCount("*")
// 4. For checking if the remaining stack is valid, we have a few conditions
//  a. First condition is - Stack is empty so everything checked out
//  b. If the topmost character is "(" means, we can't cancel it out with anything else
//  c. We count the number of stars (*) & reduce the count by 1 every time we encounter a "(". The gist is to find if all the remaining "(" can be cancelled by the stars coming after them


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