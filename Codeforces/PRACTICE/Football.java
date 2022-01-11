import java.util.*;
public class Football {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();

        int zc = 0, oc = 0;
        // Zero check
        for(int i=0; i<a.length(); i++){
            if(zc==7) break;
            else if(a.charAt(i)=='0') zc++;
            else zc=0;
        }
        // 1 check
        for(int i=0; i<a.length(); i++){
            if(oc==7) break;
            else if(a.charAt(i)=='1') oc++;
            else oc=0;
        }

        if(zc==7 || oc==7) System.out.println("YES");
        else System.out.println("NO");
    }
}
