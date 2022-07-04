import java.util.*;

public class Three_XOR {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();

            // Brute force approach - 3 nested loops
          
            // Better observation - (a^b)+(b^c)+(a^c) = n
            // If 2 numbers are zero, then [0 0 a/2] - Will give result a
            if(n%2!=0) System.out.println(-1);
            else System.out.println(0+" "+0+" "+n/2);
        }
    }
}
