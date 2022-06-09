import java.util.*;
class NPAIRS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            String str = s.next();
            int c = 0;
            HashMap<Integer, Integer> mi = new HashMap<>();
            HashMap<Integer, Integer> ad = new HashMap<>();
            for (int i=1; i<=n; i++){
                int si = Character.getNumericValue(str.charAt(i-1));
                int valmi = i-si;
                int valad = i+si;
                mi.put(valmi, mi.getOrDefault(valmi, 0)+1);
                ad.put(valad, ad.getOrDefault(valad, 0)+1); 
            }
            for (int k:mi.keySet()){
                int n1 = mi.get(k);
                c+= (n1*(n1-1))/2;
            }
            for (int k:ad.keySet()){
                int n1 = ad.get(k);
                c+= (n1*(n1-1))/2;
            }
            System.out.println(c);
        }
    }
}
