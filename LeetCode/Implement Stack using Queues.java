import java.util.*;

class MyStack {
    private Deque<Integer> q = new ArrayDeque<>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.addFirst(x);
    }
    
    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return q.poll();
    }
    
    // Get the top element.
    public int top() {
        return q.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty(){
        return q.isEmpty();
    }
}
