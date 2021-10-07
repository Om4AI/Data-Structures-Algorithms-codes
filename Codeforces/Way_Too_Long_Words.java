import java.util.*;
public class Way_Too_Long_Words{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for (int i=0; i<t; i++){
            String str = s.next();
            int n = str.length();
            if (n>10){
                StringBuffer sb = new StringBuffer();
                sb.append(str.charAt(0));
                sb.append(String.valueOf(n-2));
                sb.append(str.charAt(n-1));
                System.out.println(sb.toString());
                continue;
            }else{
                System.out.println(str);
                continue;
            }
        }
    }
}