import java.util.*;

class FIXFIX {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for (int m=0; m<t; m++){
            int n = s.nextInt();
            int k = s.nextInt();
            StringBuffer l = new StringBuffer();
            if (k==n-1) l.append("-1");
            else if (k==n){
                for (int i=1; i<=n; i++)l.append(i+" ");
            }
            else{
                for (int i=1; i<=k; i++) l.append(i+" ");
                for (int i=k+2; i<=n; i++) l.append(i+" ");
                l.append(k+1);
            }
            System.out.println(l);
        }
    }
}
