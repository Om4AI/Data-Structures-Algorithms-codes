import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    while(t-->0){
	        int n = s.nextInt();
	        int arr[] = new int[n];
	        int odd = 0;
	        for (int i=0; i<n; i++){
	            arr[i] = s.nextInt();
	            if (arr[i] % 2 !=0) odd++;
	        }
	        System.out.println(odd/2);
	    }
	}
}
