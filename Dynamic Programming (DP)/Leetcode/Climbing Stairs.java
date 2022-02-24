class Solution {
    public int climbStairs(int n){
        // 1D array for 
        int t[] = new int[n+1];
        Arrays.fill(t,0);
        return stairs(n,t);
    }
    
    public static int stairs(int n, int[] t){
        // Base Condition
        if(n==1 || n==2) return t[n] = n;
        
        // Memoization check in array
        if(t[n]!=0) return t[n];
        
        // Recursive call
        return t[n] = stairs(n-1,t)+stairs(n-2,t);
    }
}
