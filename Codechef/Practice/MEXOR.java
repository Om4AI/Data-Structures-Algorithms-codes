import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int k=0; k<t; k++){
            int n =s.nextInt();
            if (n==0){
                System.out.println(1);
                continue;
            }

            int lpow = 1;
            while(lpow*2<=n) lpow*=2;

            if (n+1==lpow*2) System.out.println(lpow*2);
            else System.out.println(lpow);
        }
	}
}
