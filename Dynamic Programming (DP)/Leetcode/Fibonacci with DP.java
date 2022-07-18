class Solution {
    public int fib(int n) {
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        
        return getFib(n,t);
    }
    
    
    public static int getFib(int n,int[] t){
        // Base case
        if(n<=1) return t[n] = n;
        
        // Memoization
        if(t[n]!=-1) return t[n];
        
        return t[n] = getFib(n-1,t) + getFib(n-2,t);
    }
}
