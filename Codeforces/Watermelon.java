import java.util.*;
public class Watermelon {

    public static String check_even(int w){
        if (w==2)return "NO";
        else if (w%2==0) return "YES";
        else return "NO";
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        System.out.println(check_even(w));
    }
}
