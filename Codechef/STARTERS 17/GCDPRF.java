// Incase that you get TLE in Qs' where output is an array - Use String as an output in JAVA
import java.util.*;
class Codechef{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++) arr[i] = s.nextInt();
            StringBuffer sb = new StringBuffer();

            int f = 1;
            for(int i=0; i<n-1; i++){
                if(arr[i]%arr[i+1]!=0){
                    f=0;
                    break;
                }else{
                    sb.append(arr[i]);
                    sb.append(" ");
                }
            }

            if(f==0) System.out.println(-1);
            else{
                sb.append(arr[n-1]);
                System.out.print(sb.toString());
            }
            System.out.println();
        }
    }
}
