import java.util.*;
public class Petya_and_Strings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();

        if(s1.compareToIgnoreCase(s2)<0)System.out.println(-1);
        else if (s1.compareToIgnoreCase(s2)>0) System.out.println(1);
        else System.out.println(0);
    }
}
