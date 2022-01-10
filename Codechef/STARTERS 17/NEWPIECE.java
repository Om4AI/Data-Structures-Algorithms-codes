import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int a = s.nextInt();
            int b = s.nextInt();
            int p = s.nextInt();
            int q = s.nextInt();

            // Even - 0 & Odd - 1
            int p1=0, p2 = 0;

            if(a==p && b==q){
                System.out.println(0);
                continue;
            }

            if((a+b)%2!=0) p1 = 1;
            if((p+q)%2!=0) p2 = 1; 

            if((p1==0 && p2==0)||(p1==1 && p2==1)){
                System.out.println(2);
                continue;
            }else if((p1==0 && p2==1)||(p1==1 && p2==0)){
                System.out.println(1);
                continue;
            }
        }
    }
}
