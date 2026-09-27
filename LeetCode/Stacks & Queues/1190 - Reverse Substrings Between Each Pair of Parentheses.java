// Link to solution - https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/solutions/8542844/java-stringbuffer-stack-step-by-step-opt-w3qq

// Approach 1 - Stack approach with an extra while loop
// Time - 23ms
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        int cp = 0, n = s.length();

        while (cp<n){
            char c = s.charAt(cp);
            if (c!=')'){
                stk.add(c);
            }else if (c==')'){
                // Remove the characters till the first '('
                StringBuffer sb = new StringBuffer();
                while (stk.peek()!='('){
                    char tempc = stk.pop();
                    sb.append(tempc);
                }
                // The next character will always be '(' since we encountered a ')' at the start
                stk.pop();
                // Add the characters into the stack again
                for (int i=0; i<sb.length(); i++) stk.add(sb.charAt(i));
            }
            cp++;
        }

        // If stack doesn't start & end with ()
        StringBuffer sb = new StringBuffer();
        while (!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}

// Approach 2 - Without stack with only a StringBuffer
// Time - 3ms
class Solution {
    public String reverseParentheses(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> openingIdxs = new Stack<>();
        int cp = 0, n = s.length();

        while (cp<n){
            char c = s.charAt(cp);
            if (c!=')'){
                if (c=='('){
                    // Update the latest opening index
                    openingIdxs.add(sb.length());
                }
                sb.append(c);
            }else if (c==')'){
                StringBuffer tempsb = new StringBuffer();
                int openIdx = openingIdxs.pop();
                // Take all characters from last opening index including the '(' & remove '(' in next step
                tempsb.append(sb.subSequence(openIdx+1, sb.length()));
                sb.delete(openIdx, sb.length());
                tempsb.reverse();
                sb.append(tempsb);
            }
            cp++;
        }
        return sb.toString();
    }
}