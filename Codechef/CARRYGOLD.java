import java.util.*;
class CARRYGOLD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            if ((n+1)*y>=x)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
