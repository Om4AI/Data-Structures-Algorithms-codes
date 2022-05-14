public class Solution {
    public int climbStairs(int n){
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        return stairs(n,t);
    }

    public static int stairs(int n, int[] t){
        // BC
        if(n==1 || n==2) t[n] = n;

        // Memoization check
        if(t[n]!=-1) return t[n];

        // Recursive call
        return t[n] = stairs(n-1,t)+stairs(n-2,t);
    }
}
