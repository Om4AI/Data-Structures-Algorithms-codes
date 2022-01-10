import java.util.*;final
class Codechef{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            if(x+y<=z) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
