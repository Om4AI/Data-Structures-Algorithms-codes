import java.util.*;

public class Swap_Bits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
        System.out.println(solve(a,b,c));
    }

    // --------------- Interview Bit Solution ------------------
    public static int solve(int a, int b, int c){
        String s = Integer.toBinaryString(a);
        int n = s.length();

        StringBuffer sb = new StringBuffer(s);
        int len = Math.max(c,Math.max(b,n));
        if(n<len){
            int z = len-n;
            sb.reverse();
            while(z-->0) sb.append('0');
            sb.reverse();
            n = sb.length();
        }

        // Get characters
        char b1 = 'a', c1 = 'a';
        b1 = (sb.charAt(n-b));
        c1 = (sb.charAt(n-c));

        sb.setCharAt(n-b, c1);
        sb.setCharAt(n-c, b1);
        return Integer.parseInt(sb.toString(),2);
    }
    // ----------------------------------------------------------
}
