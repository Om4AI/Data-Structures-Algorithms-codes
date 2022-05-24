import java.util.*;
public class Kth_Row_Pascal_Triangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int res[] = getRow(r);
        for(int i: res) System.out.print(i+" ");
    }

    public static int[] getRow(int n){
        // Base conditions
        if(n==0) return new int[]{1};
        if(n==1) return new int[]{1,1};

        List<Integer> temp = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        for(int i=1; i<n; i++){
            l = new ArrayList<>();
            l.add(1);
            for(int j=0; j<temp.size()-1; j++){
                int sum = temp.get(j)+temp.get(j+1);
                l.add(sum);
                
            }
            l.add(1);

            // Modify temp & l
            temp = l;
        }
        
        int[] res = new int[l.size()];
        for(int i=0; i<l.size(); i++) res[i] = l.get(i);
        return res;
    }
}
