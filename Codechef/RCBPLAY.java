import java.util.*;
class RCBPLAY {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i=0; i<t; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            if ((x+2*z)>=y) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
