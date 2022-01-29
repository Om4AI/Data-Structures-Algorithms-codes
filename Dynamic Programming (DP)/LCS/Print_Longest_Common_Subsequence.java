import java.util.*;
// Code by @Om

public class Print_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String a = "afghjkcbcf";
        String b = "afghtrebcdaf";

        System.out.println(print_LCS(a,b));
    }

    // FUNCTION for Printing LCS String
    public static String print_LCS(String a, String b){
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

        // Find LCS String
        int i = m, j = n;
        while(i!=0 || j!=0){
            char ac = a.charAt(i-1);
            char bc = b.charAt(j-1);
            // Conditions
            if(ac==bc){
                sb.append(ac);
                i--;
                j--;
                continue;
            }else{
                if(t[i-1][j] > t[i][j-1]){
                    i--;
                    continue;
                }else{
                    j--;
                    continue;
                }
            }
        }
        return sb.reverse().toString();
    }
}
