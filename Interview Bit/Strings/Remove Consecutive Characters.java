import java.util.*;

public class Solution {
    public String solve(String s, int b) {
        Stack<Character> stk = new Stack<>();
        char c = s.charAt(0);
        int score = 0;

        for (int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if (curr==c){
                stk.push(curr);
                score++;
            }else{
                if (score==b){
                    while(!stk.isEmpty() && score>0){
                        stk.pop();
                        score--;
                    }
                }
                stk.push(curr);
                c = curr;
                score = 1;
            }
        }

        // Test the existing stack for the last entry
        if (score==b){
            while(!stk.isEmpty() && score>0){
                stk.pop();
                score--;
            }
        }

        // Return the result
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()){
            sb.append(String.valueOf(stk.pop()));
        }
        return sb.reverse().toString();
    }
}
