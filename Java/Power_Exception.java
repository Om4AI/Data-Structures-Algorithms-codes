import java.util.*;
import java.io.*;
import java.lang.Math;

class NumberException extends Exception {
    NumberException(String s){
        super(s);
    }
}

class MyCalculator{
    public void power(int n, int p)throws NumberException{
        if (n<0 || p<0){throw new NumberException("n and p should not be negative");}
        else if(n==0 && p==0){throw new NumberException("n and p should not be be zero");}
        else{System.out.println("The result is: "+ Math.pow(n,p));}
    }
}


public class Power_Exception {
    public static void main(String[] args){
        int n, p;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value for n: ");
        n = s.nextInt();
        System.out.println("Enter the value for p: ");
        p = s.nextInt();

        MyCalculator c = new MyCalculator();
        try{
            c.power(n,p);
        }catch(Exception e){System.out.println(e);}
    }
}
