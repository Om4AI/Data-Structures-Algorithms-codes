// Easy Approach
class MinStack {
    
    Stack<Integer> stk;

//      Initialize your data structure here
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return Collections.min(stk);
    }
}

// -----------------------------------------------


// Approach 2 (Better Runtime)
class MinStack {
    
    Stack<Integer> stk;
    int min = Integer.MAX_VALUE;

//     Initialize the stack
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if (val<=min){
            stk.push(min);
            min = val;
        }
        stk.push(val);
    }
    
    public void pop() {
//         If the top of stack is same as min value; then we pop the next element as well
        if(stk.pop() == min) min = stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }
}
