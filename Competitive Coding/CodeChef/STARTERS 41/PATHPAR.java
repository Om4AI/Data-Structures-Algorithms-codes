import java.util.*;
public class PATHPAR {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-->0){
            int n = s.nextInt(), k = s.nextInt();

            if(n%2==0) System.out.println("YES");
            else if(k==1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
