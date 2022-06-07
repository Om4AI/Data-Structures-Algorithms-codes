import java.util.*;
public class WINNERR {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-->0){
            int p0 = s.nextInt(), p1 = s.nextInt();
            int q0 = s.nextInt(), q1 = s.nextInt();
            int m1 = Math.max(p0,p1), m2 = Math.max(q0,q1);

            if(m1<m2) System.out.println("P");
            else if (m2<m1) System.out.println("Q");
            else System.out.println("TIE");
        }
    }
}
