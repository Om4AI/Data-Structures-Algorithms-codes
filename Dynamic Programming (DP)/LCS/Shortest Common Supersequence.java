class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        return print_SCS(a,b);
    }
    
    public static String print_SCS(String a, String b){
        int m = a.length();
        int n = b.length();
        StringBuffer sb = new StringBuffer();

        int t[][] = new int[m+1][n+1];
        // Initialization
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        // Conditions
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        // Find SCS String
        int i = m, j = n;
        while(i!=0 && j!=0){
            char ac = a.charAt(i-1);
            char bc = b.charAt(j-1);
            // Conditions
            if(ac==bc){
                // Append the common character
                sb.append(ac);
                i--;
                j--;
                continue;
            }else{
                if(t[i-1][j] > t[i][j-1]){
                    // Moving up so append the Left character (a)
                    sb.append(ac);
                    i--;
                    continue;
                }else{
                    // Moving left so append the Top character (b)
                    sb.append(bc);
                    j--;
                    continue;
                }
            }
        }
        // Append the remaining characters
        while(i>0){
            sb.append(a.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(b.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}