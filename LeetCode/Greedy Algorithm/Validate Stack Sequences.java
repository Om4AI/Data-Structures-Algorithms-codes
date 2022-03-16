class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Total number of elements
        int n = pushed.length, i=0;
        Stack<Integer> stk = new Stack<>();

        for (int x: pushed){
            // Push the element in the stack
            stk.push(x);

            // Check the next element to be popped and the head of the stack - IF same the pop the head of the stack
            while(!stk.isEmpty() && i<n && stk.peek()==popped[i]){
                stk.pop();
                i++;
            }
        }
        return stk.isEmpty();
    }
}