import java.util.*;
import java.io.*;

class InvalidCATException extends Exception{
    InvalidCATException(String s){
        super(s);
    }
}

class InvalidQuizException extends Exception{
    InvalidQuizException(String s){
        super(s);
    }
}

public class CAT_Exception{
    static void validate_CAT(int c)throws InvalidCATException{
        if (c<0 || c>100){throw new InvalidCATException("Invalid CAT marks!");}
        else{System.out.println("CAT marks entered");}
    }

    static void validate_Quiz(int c)throws InvalidQuizException{
        if (c<0 || c>10){throw new InvalidQuizException("Invalid Quiz marks!");}
        else{System.out.println("Quiz marks entered");}
    }


    public static void main(String[] args){
        int cat, quiz;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter CAT marks: ");
        cat = s.nextInt();
        System.out.println("Enter Quiz marks: ");
        quiz = s.nextInt();
        System.out.println("\n");

        // CAT Marks
        try{
            validate_CAT(cat);
        }catch(Exception e){System.out.println(e);}

        // Quiz Marks
        try{
            validate_Quiz(quiz);
        }catch(Exception e){System.out.println(e);}

        finally{System.out.println("Marks Checked");}
    }
}
