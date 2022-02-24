class Solution {
    public int tribonacci(int n){
        // 1D array - 1 changing variable(n)
        int t[] = new int[n+1];
        
        // Initialization
        Arrays.fill(t,-1);
        return tribo_seq(n,t);
    }
    
    public static int tribo_seq(int n, int[] t){
        // Base condition
        if(n==0 || n==1) return t[n] = n;
        if(n==2) return t[n] = 1;
        
        // Memoization
        if(t[n]!=-1) return t[n];
        
        // Actual logic
        return t[n] = tribo_seq(n-1,t)+tribo_seq(n-2,t)+tribo_seq(n-3,t);
    }
}