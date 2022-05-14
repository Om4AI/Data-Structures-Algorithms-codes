import java.util.*;
public class Solution {
    public static int solve(int[][] arr) {
        int n = arr.length;
        int t[][] = new int[n+1][4];

        for(int i=0; i<n+1; i++) Arrays.fill(t[i], -1);
        return paint(arr,n,3,t);
    } 

    public static int paint(int[][] arr, int n, int color, int[][] t){
        if(n==0) return 0;
        if(n==1){
            if(color==1) return Math.min(arr[0][0], arr[0][2]);
            else if (color==0) return Math.min(arr[0][1], arr[0][2]);
            else return Math.min(arr[0][0], arr[0][1]);
        }

        // Mempization check
        // t[n][color] - Minimum cost for (n houses) where the right side house is (color painted)
        if(t[n][color]!=-1) return t[n][color];

        // Actual logic - Recursive call
        int min = Integer.MAX_VALUE;
        if(color==3){
            // Select red or blue
            min = Math.min((arr[n-1][0]+paint(arr,n-1,0,t)), (arr[n-1][1]+paint(arr,n-1,1,t)));
            // Select from min(red, blue) & green
            min = Math.min(min, arr[n-1][2]+paint(arr,n-1,2,t));
        }else if(color==0) min = Math.min((arr[n-1][1]+paint(arr,n-1,1,t)), (arr[n-1][2]+paint(arr,n-1,2,t)));
        else if(color==1) min = Math.min((arr[n-1][0]+paint(arr,n-1,0,t)), (arr[n-1][2]+paint(arr,n-1,2,t)));
        else if(color==2) min = Math.min((arr[n-1][0]+paint(arr,n-1,0,t)), (arr[n-1][1]+paint(arr,n-1,1,t)));

        // Store and return minimum
        return t[n][color] = min;
    }
}

