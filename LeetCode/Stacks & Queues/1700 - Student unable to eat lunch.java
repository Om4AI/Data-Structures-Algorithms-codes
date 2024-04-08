import java.util.*;

class Solution {
    public static boolean ispossible(Queue<Integer> stud, Stack<Integer> sandwiches){
        Queue<Integer> students = new LinkedList(stud);
        while(students.size()>0){
            int s = students.poll();
            if (sandwiches.peek()==s) return true;
        }
        return false;
    }

    public int countStudents(int[] stu, int[] sand){
         Queue<Integer> students = new LinkedList<>();
         Stack<Integer> sandwiches = new Stack<>();

        //  Add all entries to lists
        for (int i:stu) students.add(i);
        for (int i=sand.length-1; i>=0; i--) sandwiches.push(sand[i]);

        // Start the actual operation
        while (students.size()>0 && sandwiches.size()>0 && ispossible(students, sandwiches)){
            if (students.peek()==sandwiches.peek()){
                students.poll();
                sandwiches.pop();
            }else{
                int s = students.poll();
                students.add(s);
            }
        }
        return students.size();
    }
}