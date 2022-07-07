// public class Solution {
//     public static int[][] t;
//     // public static HashMap<String,Integer> map;
//     public static int coinchange2(int[] arr, int w){
//         int n = arr.length;

//         map = new HashMap<>();

//         return coinSum(arr,n,w)% 1000007;
//     }


//     public static int coinSum(int[] arr,int n, int w){
//         StringBuffer sb = new StringBuffer(String.valueOf(n));
//         sb.append(" ");
//         sb.append(String.valueOf(w));
//         String k = sb.toString();
        
//         // Base case
//         if(n==0 && w>0){
//             map.put(k,0);
//             return 0;
//         }
//         else if(w==0){
//             map.put(k,1);
//             return 1;
//         }

//         // Memoization check
//         if(map.containsKey(k)) return map.get(k);

//         // General case
//         if(arr[n-1]<=w){
//             // Include or exclude
//             int ans = coinSum(arr,n,w-arr[n-1])% 1000007+ coinSum(arr,n-1,w)% 1000007;
//             map.put(k,ans);
//         }else{
//             int ans = coinSum(arr,n-1,w)% 1000007;
//             map.put(k,ans);
//         }
//         return map.get(k);
//     }
// }









import java.util.*;
public class InfiniteCoinSum{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) arr[i] = s.nextInt();


        System.out.println("Enter Weight: ");
        int w = s.nextInt();

        System.out.println(coinchange2(arr,w));
    }

    // ------------------------- DP Functions ------------------------------
    public static int coinchange2(int[] arr, int w){
        int n = arr.length;
        // Don't make the DP array as a class data member
        int[][] t = new int[n+1][w+1];

        // Initialization
        for(int i=0; i<n+1; i++){
            t[i] = new int[w+1];
            for(int j=0; j<w+1; j++){
                if(j==0) t[i][j] = 1;
                else if(i==0 && j>0) t[i][j] = 0;
            }
        }

        return coinSum(arr,w,t);
    }


    public static int coinSum(int[] arr, int w, int[][] t){

        int n = arr.length;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(arr[i-1]<=j){
                    // Include it or exclude
                    t[i][j] = t[i][j-arr[i-1]]% 1000007 + t[i-1][j]% 1000007;
                }else t[i][j] = t[i-1][j];
                t[i][j]%= 1000007;
            }
        }
        return t[n][w];
    }
}
