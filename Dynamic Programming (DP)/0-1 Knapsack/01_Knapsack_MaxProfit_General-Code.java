import java.util.*;
public class 01_Knapsack_MaxProfit {
    public static void main(String[] args) {
        // Bottom up approach - Matrix is everything here
        // n - Number of elements & w - Size of knapsack
        int n = x, w = y;
        int wt[n] = new int[n];
        int val[n] = new int[n];
        
        // Initialization
        int t[][] = new int[n+1][w+1];

        // When (Number of elements=0) OR (Size of knapsack=0)
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 || j==0){
                    t[i][j] =0;
                }
            }
        }

        // Conditions
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(wt[i-1]<=j){
                    // Include or exclude that instance
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]] , t[i-1][j]);
                }else{
                    // Move forward
                    t[i][j] = t[i-1][j];
                }
            }
        }

        // Matrix completed
        return t[n][w];
    }
}
