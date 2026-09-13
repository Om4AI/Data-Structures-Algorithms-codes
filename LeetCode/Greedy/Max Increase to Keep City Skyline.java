import java.util.*;
import java.lang.*;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid){
        int n = grid.length;
        int NSmax[][] = new int[1][n];
        int EWmax[][] = new int[n][1];

        // Find the North-South maximums
        for(int j=0; j<n; j++){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                max = Math.max(grid[i][j], max);
            }
            NSmax[0][j] = max;
        }

        // Find the East-West maximums
        for(int i=0; i<n; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<n; j++){
                max = Math.max(grid[i][j], max);
            }
            EWmax[i][0] = max;
        }
        

        // Find the increase in heights
        int inc = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                inc+=Math.min(NSmax[0][j], EWmax[i][0]) - grid[i][j];
            }
        }
        return inc;
    }
}