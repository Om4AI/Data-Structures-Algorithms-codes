import java.util.*;

public class LCS{
    public static int LCS(String x, String y, int n, int m){
        // MATRIX creation & initialization
        int t[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(t[i], -1);
        }

        // Actual recursive calls and conditions

        // Base Condition
        if(n==0 || m==0) return 0;

        // CHECK IF VALUE ALREADY PRESENT
        if(t[n][m]!=-1) return t[n][m];

        // Other conditions
        if(x.charAt(n-1)==y.charAt(m-1)){
            return t[n][m] = 1+LCS(x, y, n-1, m-1);
        }else{
            return t[n][m] = Math.max(LCS(x, y, n-1, m), LCS(x, y, n, m-1));
        }
    }
}
