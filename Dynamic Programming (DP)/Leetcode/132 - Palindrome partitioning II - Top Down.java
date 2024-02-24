import java.util.*;
class Solution {
    public static String s;
    public static int n;
    public static int[] dp;
    public int minCut(String s1) {
        s = s1;
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return min_palindromic_cuts(0);
    }

    public static int min_palindromic_cuts(int ind){
        int min_cuts = Integer.MAX_VALUE;
        // Base case
        if (ind == n) return 0;


        // Memoization step
        if (dp[ind]!=-1) return dp[ind];


        // Actual logic loop
        for (int i=ind; i<n; i++){
            String curr = s.substring(ind, i+1);
            if (isPalindrome(curr)){
                int curr_cuts = 0;
                if (i!=n-1){
                    curr_cuts = 1 + min_palindromic_cuts(i+1);
                }else{
                    curr_cuts = min_palindromic_cuts(i+1); 
                }
                min_cuts = Math.min(curr_cuts, min_cuts);
            }
        }
        return dp[ind] = min_cuts;
    }

    // Palindrome check
    public static boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        while(l<r){
            if (str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}