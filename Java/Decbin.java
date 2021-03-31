import java.math.*;
import java.util.*;


public class Decbin {
    static void dectobin(int n){
        System.out.println("The binary number is: "+Integer.toBinaryString(n));
    }

    static void bintodec(int bin[]){
        int dec=0, c=0;
        int n = bin.length;
        for (int i=n-1 ; i>-1 ; i--){
            dec += bin[i]*Math.pow(2,c);
            c+=1;
        }
        System.out.println("\nThe decimal number for the binary number is: "+dec);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose a method:\n1. Decimal To binary\n2. Binary to Decimal");
        int choice = s.nextInt();
        switch(choice){
            case(1):
                System.out.println("Enter the decimal number: ");
                int n = s.nextInt();
                dectobin(n);
                break;
            case 2:
                System.out.println("Enter the binary number length: ");
                int l = s.nextInt();
                int bin[] = new int[l];
                System.out.println("Enter the number: ");
                for (int i=0;i<l;i++){
                    bin[i] = s.nextInt();
                }
                bintodec(bin);
        }
    } 
}
