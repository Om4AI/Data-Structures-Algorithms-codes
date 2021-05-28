import java.util.*;
import java.io.*;

class Student implements Serializable{
    String reg_no,name, proc_name;
    float cgpa;
    Student(String reg, String n, String pn, float c){
        reg_no = reg;
        name = n;
        proc_name = pn;
        cgpa = c;
    }
}



public class Student_grade{
    public static void main(String[] args)throws Exception{
        Student obj1 = new Student("19BEE0449", "Harsh", "Santhi", 82.5f);
        Student obj2 = new Student("19BCE0329", "Phoenix", "Dilip", 92.5f);
        Student obj3 = new Student("19BIT0239", "Ramesh", "Harold", 62.5f);

        System.out.println("Storing objects to file......");
        FileOutputStream fos = new FileOutputStream("stu.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(obj1);
        oos.writeObject(obj2);
        oos.writeObject(obj3);

        FileInputStream fis = new FileInputStream("stu.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("\nReading objects from file........ \n");
        for (int i=0; i<3; i++){
            Student s1 = (Student)ois.readObject();
            char grade = 'A';
            if (s1.cgpa > 90){grade = 'A';}
            else if (s1.cgpa>70 && s1.cgpa<=90){grade = 'B';}
            else if (s1.cgpa>50 && s1.cgpa<=70){grade = 'C';}
            System.out.println("\nStudent name: "+s1.name+"\nCGPA: "+s1.cgpa+"\nGrade: "+grade);
        }
    }
}
