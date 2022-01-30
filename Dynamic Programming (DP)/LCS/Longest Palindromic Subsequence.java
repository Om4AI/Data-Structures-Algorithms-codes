class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        StringBuffer sb = new StringBuffer(s);
        String b = sb.reverse().toString();
        int t[][] = new int[m+1][m+1];

        // Initialization
        for(int i=0; i<m+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        // Conditions
        for(int i=1; i<m+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1)==b.charAt(j-1)) t[i][j] = 1 + t[i-1][j-1];
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][m];
    }
}