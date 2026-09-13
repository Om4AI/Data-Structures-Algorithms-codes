import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s){
        HashMap<Character,Boolean> seen = new HashMap<>();
        HashMap<Character,Integer> occ = new HashMap<>();
        Stack<Character> stk = new Stack<>();
        int n = s.length();

        // Find occurences & seen intialization
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            seen.put(c,false);
            occ.put(c,occ.getOrDefault(c, 0)+1);
        }
        

        // Traverse & fill stack
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            
            // Single character, so skip repeating character
            if(seen.get(c)==true){
                occ.put(c,occ.get(c)-1);
                continue;
            }

            // Main case of modification
            else if(!stk.isEmpty() && c<stk.peek()){
                // Remove all the greater characters
                while(!stk.isEmpty() && c<stk.peek() && occ.get(stk.peek())>0){
                    char top = stk.pop();
                    seen.put(top, false);
                }
            }

            pushNewChar(stk,seen,occ,c);
        }

        // Pop elements to get order
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.reverse().toString();
    }

    public static void pushNewChar(Stack<Character> stk, HashMap<Character,Boolean> seen, HashMap<Character,Integer> occ, char c){
        stk.push(c);
        seen.put(c,true);
        occ.put(c,occ.get(c)-1);
    }
}