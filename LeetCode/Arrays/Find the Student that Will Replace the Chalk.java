import java.util.*;

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Find the sum of chalks
        long sum = 0;
        for(int i: chalk) sum+=i;

        // Conditions on sum - 2 Cases (a. K is greater than sum & b.Sum is greater than K)
        if(k>=sum){
            int rem = (int)((long)k % sum);
            if(rem==0) return 0;
            else return getIndex(chalk,rem);
        }else return getIndex(chalk,k);
    }

    public static int getIndex(int[] arr, int k){
        int s = 0, n = arr.length;
        for(int i=0; i<n; i++){
            s+=arr[i];
            if(s>k) return i;
        }
        return n-1;
    }
}