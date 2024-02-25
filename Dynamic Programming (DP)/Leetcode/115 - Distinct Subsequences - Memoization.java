import java.util.*;

class Solution {
    public static String s;
    public static String t;
    public static int dp[][];
    public int numDistinct(String s1, String t1){
        s = s1;
        t = t1;
        dp = new int[s.length()][t.length()];
        for (int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return no_subsequences(0, 0);
    }

    public static int no_subsequences(int sp, int tp){
        // Base Case
        if (sp==s.length() && tp<t.length()) return 0;
        if (tp == t.length()) return 1;
        
        // Memoization
        if (dp[sp][tp]!=-1) return dp[sp][tp];

        // Actual logic
        if (s.charAt(sp)==t.charAt(tp)){
            // Take or leave
            return dp[sp][tp] = no_subsequences(sp+1, tp+1) + no_subsequences(sp+1, tp);
        }else{
            return dp[sp][tp] = no_subsequences(sp+1, tp);
        }
    }
}