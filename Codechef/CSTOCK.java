import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int S = s.nextInt();
            int A = s.nextInt();
            int B = s.nextInt();
            int C = s.nextInt();

            double val = S*((100+C)/(double)100);
            if(val<A || val>B){
                System.out.println("NO");
            }else System.out.println("YES");
        }
	}
}
