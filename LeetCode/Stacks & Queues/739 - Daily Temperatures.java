/* 
 * Whenever the question contains something like - Find the next value
 * greater than or lesser than the current one and also has
 * another condition of solving the question with a O(n) time complexity 
 * then the question could most probably be solved with the use of Stack.
 */


import java.util.*;

class TValIndex{
    int value;
    int index;

    TValIndex(int value, int index){
        this.value = value;
        this.index = index;
    }
}



class Solution {
    public int[] dailyTemperatures(int[] temps) {
        // Initialization
        Stack<TValIndex> stk = new Stack<>();
        int[] res = new int[temps.length];

        // Logic
        for (int i=0; i<temps.length; i++){
            int val = temps[i];
            TValIndex obj = new TValIndex(val, i);

            // Stack is empty
            if (stk.isEmpty()){
                stk.push(obj);
            }
            // Stack has values
            else{
                if (!stk.isEmpty() && val<=stk.peek().value){
                    stk.push(obj);
                }else{
                    // Remove smaller elements and fill their result
                    while(!stk.isEmpty()){
                        if (stk.peek().value<val){
                            TValIndex temp = stk.pop();
                            res[temp.index] = obj.index - temp.index;
                        }else{
                            break;
                        }
                        
                    }
                    stk.push(obj);
                }
            }
        }

        while (!stk.isEmpty()){
            TValIndex temp = stk.pop();
            res[temp.index] = 0;
        }

        // Result
        return res;
    }
}