import java.util.*;

public class BitAdd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = 0;
        while(n-->0){
            String str = s.next();
            if(str.contains("+")) x++;
            else x--;
        }
        System.out.println(x);
    }
}
