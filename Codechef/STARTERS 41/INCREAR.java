import java.util.*;
public class INCREAR {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while(t-->0){
            int x = s.nextInt(), y = s.nextInt();

            // Cases
            if(y>x) System.out.println(y-x);
            else if (x>y){
                int d = x-y;
                if(d%2==0) System.out.println(d/2);
                else System.out.println((d/2)+2);
            }else System.out.println(0);
        }
    }
}
