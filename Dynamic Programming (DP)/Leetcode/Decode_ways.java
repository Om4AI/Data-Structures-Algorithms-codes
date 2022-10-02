import java.util.*;
class Solution {
    public static HashMap<String,Character> map;
    public static String s;
    public int numDecodings(String s1){
        
        // Create map with characters
        map = new HashMap<>();
        s = s1;
        for(char c='A'; c<='Z'; c++){
            map.put(String.valueOf((int)c-64),c);
        }

        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return getWays(0,dp);
    }
    
    public static int getWays(int i, int[] dp){
        // Base condition
        if(i==s.length()-1){
            if(map.containsKey(String.valueOf(s.charAt(i)))) return 1;
            else return 0;
        }
        if(i==s.length()) return 1;
        

        // Memoization
        if(dp[i]!=-1) return dp[i];

        // General case
        char c = s.charAt(i);
        int res = 0;
        if(map.containsKey(String.valueOf(c))){
            // Check pair of characters
            if(i+2<=s.length()){
                String str = s.substring(i,i+2);
                if(map.containsKey(str)) res = getWays(i+2,dp) + getWays(i+1,dp);
                else res = getWays(i+1,dp);
            } 
        }
        return dp[i] = res;
    }
}