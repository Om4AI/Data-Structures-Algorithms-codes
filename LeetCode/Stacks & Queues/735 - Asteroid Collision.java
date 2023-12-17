import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stk = new Stack<>();

        // Stack filling
        for (int i=0; i<n; i++){
            int num = asteroids[i];

            if(!stk.isEmpty() && num<0 && stk.peek()>0){
                int equal_found = 0;
                if (Math.abs(num)>stk.peek()){
                    while(!stk.isEmpty() && stk.peek()>0 && Math.abs(num)>=stk.peek()){
                        if ((num+stk.peek())==0){
                            stk.pop();
                            equal_found = 1;
                            break;
                        }
                        stk.pop();
                    }
                    if ((equal_found==0) && (stk.isEmpty() || stk.peek()<0)){
                        stk.push(num);
                    }
                }else if (Math.abs(num)==stk.peek()){
                    stk.pop();
                }
            }else{
                stk.push(num);
            }
        }
        
        // Create the resultant array
        int[] res = new int[stk.size()];
        int p = res.length-1;
        while(p>=0){
            res[p] = stk.pop();
            p--;
        }
        return res;
    }
}