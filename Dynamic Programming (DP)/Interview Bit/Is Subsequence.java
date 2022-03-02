// Is Subsequence - Using LCS (Longest Common Substring)

class Solution {
    public boolean isSubsequence(String s, String t) {
        return subsequence(s,t) == s.length();
    }
    
    public static int subsequence(String s, String t1){
        int n1 = s.length(), n2 = t1.length(); 
        int t[][] = new int[n1+1][n2+1];
        
        // Initialization
        for(int i=0; i<n1+1; i++){
            for(int j=0; j<n2+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }
        
        // Actual logic
        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(s.charAt(i-1)==t1.charAt(j-1)) t[i][j] = 1+t[i-1][j-1];
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n1][n2];
    }
}
