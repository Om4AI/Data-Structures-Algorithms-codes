import java.util.*;
import java.math.*;


public class Test_1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        int i,j;
        int f=0;
        int n1=s1.length();
        String s2=s1.toLowerCase();
        for (i=0;i<n1/2;i++) {
            if (s2.charAt(i)!=s2.charAt(n1-1-i)) {
                f=1;
                break;
            }
            else {
                continue;
            }
        }
        System.out.print(f==0?"Yes":"No");
    }
}

