import java.util.*;

public class Next_Round {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int bm =0, res =0;
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
            if(i==k-1) bm = arr[i];
        }

        for(int i=0; i<n; i++){
            if(arr[i]>0 && arr[i]>=bm) res++;
        }
        System.out.println(res);
    }
}
