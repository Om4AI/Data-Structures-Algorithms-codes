import java.util.*;

public class Solution {
    public static int ninjaTraining(int n, int arr[][]){
        int dp[][] = new int[n+1][4];

        // Initialize
        dp[n-1][0] = Math.max(arr[n-1][1], arr[n-1][2]);
        dp[n-1][1] = Math.max(arr[n-1][0], arr[n-1][2]);
        dp[n-1][2] = Math.max(arr[n-1][1], arr[n-1][0]);
        dp[n-1][3] = Math.max(arr[n-1][1], Math.max(arr[n-1][2], arr[n-1][0]));

        // Fill up the other matrix
        for(int i=n-2; i>=0; i--){
            for(int prev=0; prev<=3; prev++){
                int max = Integer.MIN_VALUE;

                for(int task=0; task<=2; task++){
                    if(task!=prev) {
                        int curr = arr[i][task]+dp[i+1][task];
                        max = Math.max(max, curr);
                    }
                }
                dp[i][prev] = max;
            }
        }
        return dp[0][3];
    }
}