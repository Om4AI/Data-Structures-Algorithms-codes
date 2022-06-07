import java.util.*;
public class CCHOCOLATES {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-->0){
            int x = s.nextInt(), y = s.nextInt(), z = s.nextInt();
            System.out.println((5*x + 10*y)/z);
        }
    }
}
