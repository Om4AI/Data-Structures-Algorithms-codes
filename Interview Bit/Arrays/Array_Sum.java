import java.util.*;

public class Array_Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the lengths of the arrays: ");
        int n = s.nextInt();
        int n1 = s.nextInt();
        int arr1[] = new int[n], arr2[] = new int[n1];

        for(int i=0; i<n; i++) arr1[i] = s.nextInt();
        for(int i=0; i<n1; i++) arr2[i] = s.nextInt();

        int res[] = addArrays(arr1, arr2);
        for(int i: res) System.out.print(i+" ");
    }


    public static int[] addArrays(int[] a, int[] b){
        List<Integer> l = new ArrayList<>();
        int c = 0, n1 = a.length-1, n2 = b.length-1;

        while(n1>=0 && n2>=0){
            int sum = a[n1]+b[n2]+c;

            // Add the units digit to result
            l.add(0,sum%10);
            
            // Modify carry
            if(sum>=10) c=1;
            else c=0;

            n1--;
            n2--;
        }

        while(n1>=0){
            int sum = a[n1]+c;
            l.add(0,sum%10);
            if(sum>=10) c=1;
            else c=0;
            n1--;
        }

        while(n2>=0){
            int sum = b[n2]+c;
            l.add(0,sum%10);
            if(sum>=10) c=1;
            else c=0;
            n2--;
        }
        if(c==1) l.add(0,c);

        int res[] = new int[l.size()];
        for(int i=0; i<l.size(); i++) res[i] = l.get(i);
        return res;
    }
}
