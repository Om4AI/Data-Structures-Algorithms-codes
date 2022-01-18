import java.util.*;

public class Max_Profit_General_Code {
    public static int unbounded_knapsack(){
        // Variables (Length & Weight of Knapsack)
        int n, w;
        int val[] = new int[n];
        int wt[] = new int[n];
        // DP Matrix
        int t[][] = new int[n+1][w+1];

        // Initialzation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 || j==0) t[i][j]=0;
            }
        }

        // Actual Logic Conditions - Here t[][] matrix has values of Profit
        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(wt[i-1]<=j){
                    // Include or Exclude
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
