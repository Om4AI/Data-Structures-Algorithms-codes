class Solution {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        
        int t[][] = new int[m+1][n+1];
//         Initialization
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }
        
//         Conditions
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1)) t[i][j] = 1 + t[i-1][j-1];
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        int lcs = t[m][n];
        return (m-lcs + n-lcs);
    }
}
