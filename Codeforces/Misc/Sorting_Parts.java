import java.util.*;
public class Sorting_Parts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-->0){
            int n = s.nextInt(), max=Integer.MIN_VALUE, f=0;
            int arr[] = new int[n];
            for(int i=0; i<n; i++) arr[i] = s.nextInt();

            for(int i=0; i<n; i++){
                if(arr[i]<max){
                    f = 1;
                    break;
                }else{
                    max = Math.max(max, arr[i]);
                }
            }
            if(f==1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
