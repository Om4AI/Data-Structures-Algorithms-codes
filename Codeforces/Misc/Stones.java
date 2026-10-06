import java.util.*;
public class Stones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String s1 = s.next();
        int c = 0;
        for(int i=1; i<n; i++){
            if(s1.charAt(i)==s1.charAt(i-1))c++;
        }
        System.out.println(c);
    }
}
