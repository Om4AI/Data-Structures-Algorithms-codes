// Memoization Solution
import java.util.*;
class Solution {
    public static int[][] t;
    public int maxArea(int[] height) {
        int n = height.length;
        t = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return get_max_water(0, n-1, height);
    }

    public static int get_max_water(int start, int end, int[] arr){
        int n = arr.length;

        if(start<end && end-start==1) return Math.min(arr[start],arr[end]);
        if(start==end) return 0;

        // Check if result is memoized
        if(t[start][end]!=-1) return t[start][end];

        int max = Integer.MIN_VALUE;
        
        max = Math.max((Math.min(arr[start], arr[end])*(end-start)), get_max_water(start+1, end, arr));
        max = Math.max(max, get_max_water(start+1, end-1, arr));
        max = Math.max(max, get_max_water(start, end-1, arr));
        return t[start][end] = max;
    }
}