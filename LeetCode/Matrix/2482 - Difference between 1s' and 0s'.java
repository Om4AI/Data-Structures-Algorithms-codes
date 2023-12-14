import java.util.*;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int rows[] = new int[m];
        int cols[] = new int[n];
        int[][] diff = new int[m][n];


        // Traverse and fill the maps
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }


        // Fill the difference matrix
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                diff[i][j] = (2*rows[i] + 2*cols[j] - m - n);
            }
        }
        return diff;
    }
}