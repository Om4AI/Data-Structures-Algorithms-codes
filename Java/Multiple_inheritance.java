import java.util.*;
import java.io.*;

interface factorial{
    void getfactorial(int n);
}

interface sum{
    void getsum(int n);
}

class inherited implements factorial,sum{
    public void getfactorial(int n){
        int fact = 1;
        for (int i=2;i<=n;i++){
            fact *= i;
        }
        System.out.println("\nThe factorial is: "+fact);
    }

    public void getsum(int n){
        int sum = (n*(n+1))/2;
        System.out.println("\nThe sum is: "+sum);
    }
}

public class Multiple_inheritance {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("\n\nEnter the number: ");
        int n = s.nextInt();
        inherited obj = new inherited();
        obj.getfactorial(n);
        obj.getsum(n);
    }
}
