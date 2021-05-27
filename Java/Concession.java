import java.util.*;
import java.io.*;

class InvalidAgeException extends Exception{
    InvalidAgeException(String s){
        super(s);
    }
}


public class Concession_exceptions{

    static void validate(int m, int f)throws InvalidAgeException{
        if (m>21 && f>18){System.out.println("Discount received: 5%\n");}
        else{throw new InvalidAgeException("Invalid ages for couples");}
    }

    static void validate(String gender, int age)throws InvalidAgeException{
        if (gender.equals("male")){
            if (age>65){System.out.println("Discount received: 25%\n");}
            else{throw new InvalidAgeException("Invalid Age");}
        }
        else if (gender.equals("female")){
            if (age>60){System.out.println("Discount received: 10%\n");}
            else{throw new InvalidAgeException("Invalid Age");}
        }
    }


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String gender;
        int age, m, f;
        String c;
        System.out.print("\nEnter category you want to apply for:\n1. Couple\n2. male\n3. female\n");
        c = s.next();
        if (c.equals("Couple")){
            System.out.println("Enter male & female ages: ");
            m = s.nextInt();
            f = s.nextInt();
            try{
                validate(m, f);
            }catch(Exception e){System.out.println(e);}
        }

        else if (c.equals("male") || c.equals("female")){
            System.out.println("\nEnter age: ");
            age = s.nextInt();
            try{
                validate(c, age);
            }catch(Exception e){System.out.println(e);}
        }

    }
}
