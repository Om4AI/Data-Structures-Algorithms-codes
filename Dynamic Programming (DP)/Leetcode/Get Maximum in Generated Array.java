import java.util.*;

class Solution {
    public int getMaximumGenerated(int n) {
        
        // Array to store values
        int t[] = new int[n+1];
        Arrays.fill(t, -1);
        
        // Fill the array using memoization
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n+1; i++){
            t[i] = genElement(t,i);
            max = Math.max(max, t[i]);
        }
        return max;
    }
    
    public static int genElement(int[] t, int n){
        // Base condition
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        
        // Memoization approach
        if(t[n]!=-1) return t[n];
        
        // Actual logic
        if(n%2==0){
            return t[n] = genElement(t,n/2);
        }else return t[n] = genElement(t,(n-1)/2) + genElement(t,((n-1)/2)+1);
    }
}