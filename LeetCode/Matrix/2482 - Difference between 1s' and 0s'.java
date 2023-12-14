// Optimized Solution - 10 ms in Leetcode

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


// Lesser optimized solution - 52 ms in Leetcode
// The below code has the same O(m*n) time complexity, but the use of HashMaps has led to greater time complexity than arrays
import java.util.*;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        int[][] diff = new int[m][n];

        // Traverse and fill the maps
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    rows.put(i, rows.getOrDefault(i, 0)+1);
                    cols.put(j, cols.getOrDefault(j, 0)+1);
                }else{
                    if(!rows.containsKey(i)){
                        rows.put(i, 0);
                    }
                    if (!cols.containsKey(j)){
                        cols.put(j, 0);
                    }
                }
            }
        }

        // Fill the difference matrix
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                diff[i][j] = (2*rows.get(i) + 2*cols.get(j) - m - n);
            }
        }
        return diff;
    }
}
