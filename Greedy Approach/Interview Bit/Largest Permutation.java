public class Solution {
    static int[] arr;
    public int[] solve(int[] A, int k){
        arr = new int[A.length];
        for(int i=0; i<A.length; i++) arr[i] = A[i];
        
        int p = 0;
        while(p<arr.length && k-->0){
            boolean canSwap = swap(p);
            if(!canSwap) k++;
            p++;
        }
        return arr;
    }


    public static boolean swap(int p){
        // Find the number to swap
        int n = arr.length, el = Integer.MIN_VALUE, index = -1;
        for(int i=n-1; i>=p; i--){
            if(arr[i]>el){
                el = arr[i];
                index = i;
            }
        }

        // Swap the element
        if(arr[p]>=el) return false;
        else{
            int t = arr[p];
            arr[p] = el;
            arr[index] = t;
        }
        return true;
    }
}
