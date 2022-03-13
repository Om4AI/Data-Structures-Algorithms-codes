import java.util.*;
public class Solution {
    public int[] prevSmaller(int[] arr){
        int n = arr.length;
        int res[] = new int[n];

        Stack<Integer> stk = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int el = arr[i];
            if(stk.isEmpty()){
                stk.push(el);
                index.push(i);
            }
            else{
                while(!stk.isEmpty() && stk.peek()>el){
                    stk.pop();
                    int temp = index.pop();
                    res[temp] = el;
                }
                stk.push(el);
                index.push(i);
            }
        }

        // Elements in stack for which we put -1
        while(!index.isEmpty()){
            int temp = index.pop();
            res[temp] = -1;
        }

        return res;
    }
}
