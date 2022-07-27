import java.util.*;

public class Solution {
    public static int frogJump(int n, int arr[]){
        int dp[] = new int[n+1];

        // Initialization
        dp[0] = 0;
        dp[1] = Math.abs(arr[0] - arr[1]);

        // Bottom up fill
        for(int i=2; i<n; i++){
            dp[i] = Math.min(dp[i-1]+(Math.abs(arr[i-1]-arr[i])), dp[i-2]+(Math.abs(arr[i-2]-arr[i])));
        }
        return dp[n-1];
    }
}
