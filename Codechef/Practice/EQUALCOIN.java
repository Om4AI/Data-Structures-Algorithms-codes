import java.util.*;

class Codechef{
	public static void main (String[] args) throws java.lang.Exception{
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    while(t-->0){
	        int x = s.nextInt();
	        int y = s.nextInt();
	        int val = x+2*y;
	        if (val>0 && x==0 && y%2==0)System.out.println("YES");
	        else if (val>0 && x>0 && val%2==0)System.out.println("YES");
	        else System.out.println("NO");
	    }
	}
}
