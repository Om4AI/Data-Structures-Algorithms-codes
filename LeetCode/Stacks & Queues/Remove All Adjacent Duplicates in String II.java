import java.util.*;
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stk.isEmpty() && c==stk.peek()[0]){
                stk.peek()[1]++;
            }else{
                stk.push(new int[]{c,1});
            }

            // Check if peek is full
            if(stk.peek()[1]==k) stk.pop();
        }


        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()){
            int t[] = stk.pop();
            int occ = t[1];
            while(occ-->0){
                sb.append((char)t[0]);
            }
        }
        return sb.reverse().toString();
    }
}