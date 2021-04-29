import java.util.*;
import java.io.*;

class InvalidDetailsException extends Exception {
    InvalidDetailsException(String s){
        super(s);
    }
}

class CheckDetails{
    void validate_det(int f,int m,String c)throws InvalidDetailsException{
        if (f>18 && m>21 && c.equals("couple")){System.out.println("Congrats you got 10% discount");}
        else{throw new InvalidDetailsException("Not eligible for discount");}
    }

    void validate_det(int age, String c) throws InvalidDetailsException{
        if (c.equals("male") && (age>65)){System.out.println("You got 15% discount");}
        else if (c.equals("female") && (age>60)){System.out.println("You got 20% discount");}
        else{throw new InvalidDetailsException("Not eligible for discount");}
    }
}

public class Travel_Agency_exception{
    public static void main(String args[]){
        CheckDetails cd = new CheckDetails();
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter the category you want to apply for discount: ");
        String type = s.next();
        if (type.equals("male") || type.equals("female")){
            System.out.println("\nEnter your age: ");
            int age = s.nextInt();
            try{
                cd.validate_det(age, type);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if (type.equals("couple")){
            int f = s.nextInt();
            int m = s.nextInt();
            try{
                cd.validate_det(f, m, type);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}