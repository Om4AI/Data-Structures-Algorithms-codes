class Solution {
    public int climbStairs(int n){
        
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        return getWays(t,n);
    }
    
    public static int getWays(int[] t, int n){
        // Base case
        if(n==1 || n==2) return t[n] = n;
        
        // Memoization
        if(t[n]!=-1) return t[n];
        
        return t[n] = getWays(t,n-1) + getWays(t,n-2);
    }
}
