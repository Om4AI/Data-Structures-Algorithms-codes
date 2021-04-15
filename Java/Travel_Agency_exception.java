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
        else{throw new InvalidDetailsException("Invalid details");}
    }

    void validate_det(int age, String c) throws InvalidDetailsException{
        if (c.equals("male") && (age>65)){System.out.println("You got 15% discount");}
        else if (c.equals("female") && (age>60)){System.out.println("You got 20% discount");}
        else{throw new InvalidDetailsException("Invalid details");}
    }
}

public class Travel_Agency_exception{
    public static void main(String args[]){
        int age;
        String c;
        CheckDetails cd = new CheckDetails();
        try{
            cd.validate_det(50, "male");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}