// Approach 1
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuffer sb = new StringBuffer(num);
        if (n==k) return "0";

        // Remove peak elements till we reach end of increasing array
        while(k-->0){
            int i=0;
            while(i<sb.length()-1 && sb.charAt(i)<=sb.charAt(i+1)) i++;
            sb.deleteCharAt(i);
        }

        // Remove leading zeroes
        while(sb.toString().startsWith("0")){
            sb.deleteCharAt(0);
        }
        return sb.length()==0? "0": sb.toString();
    }
}


// Approach 2
import java.util.*;
class Solution {
    public String removeKdigits(String num, int k){
        int n = num.length();
        if(n==k) return "0";

        Stack<Character> stk = new Stack<>();
        for(int i=0; i<n; i++){
            while(k>0 && !stk.isEmpty() && num.charAt(i)<stk.peek()){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
        }

        // Equal Case
        while(k>0 && !stk.isEmpty()){
            stk.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();

        // Leading zeroes
        while(sb.toString().startsWith("0")) sb.deleteCharAt(0);
        return sb.length()==0? "0":sb.toString();
    }
}