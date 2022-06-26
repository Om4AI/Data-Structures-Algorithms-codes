import java.util.*;

public class Anti_Diagonals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        int n = s.nextInt();
        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                list.add(s.nextInt());
            }
            A.add(list);
        }
        System.out.println(diagonal(A));
    }


    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size()==1){
            res.addAll(UpperTriangle(A));
            return res;
        }
        res.addAll(UpperTriangle(A));
        res.addAll(LowerTriangle(A));
        return res;
    }


    public static ArrayList<ArrayList<Integer>> UpperTriangle(ArrayList<ArrayList<Integer>> A){
        // Add (0,0) element
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(A.get(0).get(0));
        res.add(l);

        // Initialize the pointers and traverse
        int r = 1, c = 1, n = A.size();
        while(r<n && c<n){
            // Traverse in the range 
            ArrayList<Integer> t = new ArrayList<>();
            int c1 = c, r1 = 0;
            while(c1>=0 && r1<=r){
                t.add(A.get(r1).get(c1));
                c1--;
                r1++;
            }
            res.add(t);
            c++;
            r++;
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> LowerTriangle(ArrayList<ArrayList<Integer>> A){
        // Add the last element
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(A.get(n-1).get(n-1));
        res.add(l);

        // Initialize pointers
        int c = n-2,  r = n-2;
        while(c>0 && r>0){
            // Traverse the range
            ArrayList<Integer> t = new ArrayList<>();
            int c1 = n-1, r1 = r;
            while(r1<=n-1 && c1>=0){
                t.add(A.get(r1).get(c1));
                r1++;
                c1--;
            }
            res.add(0, t);
            r--;
            c--;
        }
        return res;
    }
}
