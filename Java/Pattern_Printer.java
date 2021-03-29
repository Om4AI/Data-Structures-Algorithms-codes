import java.util.*;
import java.math.*;

public class Pattern_Printer {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number if lines: ");
        int n = s.nextInt();
        int num,count=1;
        if (n%2==0){
            num = n/2;
        }
        else{num = (n/2)+1;}
        for (int i=1;i<=num;i++){
            if (count<=n){
                for (int j=1;j<=i;j++){
                    System.out.print(j);
                }
                count+=1;
            }
            System.out.println();
        }
        for (int i=num;i>=1;i--){
            if (count<=n){
                for (int j=1;j<=i;j++){
                    System.out.print(j);
                }
                count+=1;
            }
            System.out.println();
        }
    }
}
