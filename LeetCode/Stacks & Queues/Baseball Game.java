// Stack solution Java

import java.util.*;

class Solution {
    public int calPoints(String[] s) {
        Stack<Integer> stk = new Stack();
        int nums = 1;
        String str= "";
        for (int i=0; i<s.length; i++){
            try{
                nums = Integer.parseInt(s[i]);
                stk.push(nums);
            }catch(Exception e){
                str = s[i];
                // Conditions
                if (str.equals("+")){
                    int num1 = stk.pop();
                    int new_int = num1+stk.peek();
                    stk.push(num1);
                    stk.push(new_int);
                }else if (str.equals("D")){
                    stk.push(2*stk.peek());
                }else if (str.equals("C")){
                    stk.pop();
                }
            }
        }
        int sum = 0;
        // Get sum of stack elements
        while (!stk.empty()){
            sum+=stk.pop();
        }
        return sum;
    }
}
