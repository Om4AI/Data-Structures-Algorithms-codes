import java.util.*;
class Solution {
    public int countPrimes(int n){
        boolean notPrime[] = new boolean[n];
        int res = 0;
        for(int i=2; i<n; i++){
            // Prime - Increase count
            if(!notPrime[i]){
                res++;

                // Set the multiples of the number as notPrime
                for(int j=2; i*j<n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        return res;
    }
}