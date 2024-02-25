import java.util.*;

// --------------- Bottom Up ---------------
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean dp[] = new Boolean[n+1];
        
        dp[n] = true;
        for (int j=n-1; j>=0; j--){
            boolean res = false;
            for (int i=j; i<Math.min(n, j+21); i++){
                String curr_substring = s.substring(j, i+1);
    
                // Check if current substring is present in word dictionary
                if (wordDict.contains(curr_substring)){
                    // Break here and call recursive on rest OR continue
                    res = res || dp[i+1];
                }
            }
            dp[j] = res;
        }
        return dp[0];
    }
}


// --------------- Top Down ---------------
// Take care of the Constraints - Better Optimized solution
class Solution {
    public static String s;
    public static List<String> dict;
    public static int n;
    public static Boolean dp[];
    public boolean wordBreak(String s1, List<String> wordDict){
        s = s1;
        dict = wordDict;
        n = s.length();
        dp = new Boolean[n];

        return can_wordbreak(0);
    }

    public static boolean can_wordbreak(int ind){
        boolean res = false;

        // Base case
        if (ind == n) return true;

        // Memoization
        if (dp[ind]!=null) return dp[ind];

        // Actual logic loop{
        for (int i=ind; i<Math.min(n, ind+21); i++){
            String curr_substring = s.substring(ind, i+1);

            // Check if current substring is present in word dictionary
            if (dict.contains(curr_substring)){
                // Break here and call recursive on rest OR continue
                res = res || can_wordbreak(i+1);
            }
        }
        return dp[ind] = res;
    }
}