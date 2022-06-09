import java.util.*;
class SUBTASK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n  = s.nextInt();
            int m = s.nextInt();
            int k = s.nextInt();
            int mf=1, nf=1;
            int arr[] = new int[n];
            for (int i=0; i<n; i++) arr[i]=s.nextInt();

            for (int i=0; i<n; i++){
                if (arr[i]!=1 && i<m){
                    mf=0;
                    nf=0;
                    break;
                }else if (arr[i]!=1 && i>=m && i<n){
                    nf=0;
                    break;
                }
            }
            if (nf==1)System.out.println(100);
            else if (mf==1)System.out.println(k);
            else System.out.println(0);
        }
    }
}
