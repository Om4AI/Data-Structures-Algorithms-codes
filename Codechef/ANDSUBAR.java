/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception{
        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        for (int i=0; i<t; i++){
            int n = s.nextInt();
            if(n==1){
                System.out.println(1);
                continue;
            }
            int lp = 1;
            while(lp*2<=n) lp*=2;
            int last_diff = n-lp+1;
            System.out.println(Math.max(last_diff,lp/2));
        }
	}
}
