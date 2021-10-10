import java.util.*;
public class Theatre_Square {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int a = s.nextInt();
        System.out.println((long)get_tiles(n,a)*get_tiles(m,a));
    }

    public static int get_tiles(int l, int s){
        int q = l/s;
        if (l%s!=0) q+=1;
        return q;
    }
}
