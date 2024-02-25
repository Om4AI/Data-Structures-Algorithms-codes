import java.util.*;
public class Solution {
    public static String s;
    public static List<String> dict;
    public static int n;
    public static Boolean dp[];
    public int wordBreak(String s1, ArrayList<String> wordDict){
        s = s1;
        dict = wordDict;
        n = s.length();
        dp = new Boolean[n];

        return can_wordbreak(0)==false? 0:1;
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
