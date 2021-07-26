import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stk = new Stack<Integer>(); //Sandwitches
        Queue<Integer> q = new LinkedList<Integer>();  //Students
        for (int i=sandwiches.length-1; i>=0; i--){stk.push(sandwiches[i]);}
        for(int i:students){q.add(i);}
        while ((!stk.empty() && !q.isEmpty()) && q.contains(stk.peek())){
            if (stk.peek() == q.peek()){
                stk.pop();
                q.poll();
            }
            else{
                int s = q.poll();
                q.add(s);
            }
        }
        return q.size();
    }
}
