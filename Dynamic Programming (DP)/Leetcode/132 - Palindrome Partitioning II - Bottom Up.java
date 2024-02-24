import java.util.*;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        // Initialization
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i=n-1; i>=0; i--){
            for (int j=i; j<n; j++){
                String curr = s.substring(i, j+1);
                if (isPalindrome(curr)){
                    int curr_cuts = 0;
                    if (j!=n-1){
                        curr_cuts = 1 + dp[j+1];
                    }else{
                        curr_cuts = dp[j+1]; 
                    }
                    dp[i] = Math.min(curr_cuts, dp[i]);
                }
            }
        }
        return dp[0];
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