import java.util.*;

class Student{
    String regno;
    String name;
}

class Exam extends Student{
    int marks[] = new int[6];
}

class Result extends Exam{
    int total_marks=0;
    public void getvalues(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name & registration number of student: ");
        name = s.next();
        regno = s.next();
        System.out.println("Enter the marks of the 6 subjects: ");
        for (int i =0;i<6;i++){
            marks[i] = s.nextInt();
            total_marks+=marks[i];
        }
    }

    public void printer(){
        System.out.println("\n\nName of student: "+name);
        System.out.println("\nThe total marks are: "+total_marks);
    }
}


public class Inheritance {
    public static void main(String[] args){
        Result r = new Result();
        r.getvalues();
        r.printer();
    }
}
