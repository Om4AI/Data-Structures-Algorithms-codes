import java.util.*;

public class Two_Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), k = s.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = s.nextInt();

        int res[] = twoSum(arr,k);
        System.out.print("Index 1:"+res[0]+"||Index 2:"+res[1]);
    }


    public static int[] twoSum(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int el = arr[i], rem = k-el;

            // Check its pair already occured
            if(map.containsKey(el)) return new int[]{map.get(el)+1, i+1};
            
            // Put own value
            if(!map.containsKey(rem)) map.put(rem, i);
        }
        return new int[]{};
    }
}
