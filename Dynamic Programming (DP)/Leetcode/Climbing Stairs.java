import java.util.*;
class Solution {
    public static int t[];
    public int climbStairs(int n) {
        t = new int[n+1];
        Arrays.fill(t, -1);

        return distinctWays(n);
    }

    public int distinctWays(int n){
        // Base cases
        if (n==1) return 1;
        else if (n==2) return 2;

        // Memoization (Check if that value already exists)
        if (t[n]!=-1) return t[n];

        // Store the value for accessing later
        return t[n] = distinctWays(n-1) + distinctWays(n-2);
    }
}
