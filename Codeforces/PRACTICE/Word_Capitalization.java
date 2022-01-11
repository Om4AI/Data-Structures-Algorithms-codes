import java.util.*;
public class Word_Capitalization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(s.next());
        char c = sb.charAt(0);
        sb.replace(0, 1, String.valueOf(c).toUpperCase());
        System.out.println(sb.toString());
    }
}
