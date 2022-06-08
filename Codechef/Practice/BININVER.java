import java.util.*;
class BININVER {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }

            // Check if any odd
            int odd = 0;
            for (int num:arr){
                if (num%2!=0){
                    odd=1;
                    break;
                }
            }
            if (odd==1){
                System.out.println(0);
                continue;
            }
            // No. of steps to make odd
            List<Integer> l = new ArrayList<>();
            for (int i=0; i<arr.length; i++){
                int n1 = arr[i];
                int c = 0;
                while(n1%2==0){
                    n1 = (int)Math.floor(n1/2);
                    c++;
                }
                l.add(c);
            }
            // Output the minimum no. of steps required
            System.out.println(Collections.min(l));
        }
    }
}
