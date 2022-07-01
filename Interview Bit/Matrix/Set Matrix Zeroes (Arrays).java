import java.util.*;

class Solution {
    public void setZeroes(int[][] grid) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Set the rows to zero
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows.contains(i) || columns.contains(j)) grid[i][j] = 0;
            }
        }
    }
}
