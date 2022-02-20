import java.util.*;
public class Reverse_and_Concatenate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            String str = s.next();
            if(k==0){
                System.out.println(1);
                continue;
            }

            // Check palindrome
            int p1 = 0, p2 = str.length()-1, f = 1;
            while(p1<p2){
                if(str.charAt(p1)!=str.charAt(p2)){
                    f = 0;
                    break;
                }
                p1++;
                p2--;
            }
            // Final result
            if(f==1){
                System.out.println(1);
                continue;
            }else System.out.println(2);
        }
    }
}
