import java.util.*;
public class Team {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int count = 0;
        while(t-->0){
            int p = s.nextInt();
            int v = s.nextInt();
            int t1 = s.nextInt();
            int c = 0;
            if(p==1) c++;
            if(v==1) c++;
            if(t1==1) c++;

            if(c>=2) count++;
        }
        System.out.println(count);
    }
}
