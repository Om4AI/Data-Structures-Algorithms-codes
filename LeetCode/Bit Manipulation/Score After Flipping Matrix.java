import java.util.*;
class Solution {
    public int matrixScore(int[][] grid) {
        int res = 0, rows = grid.length, cols=grid[0].length;
        // Row logic
        for(int i=0; i<rows; i++){
            if(grid[i][0]==0){
                flip_row(i, grid, cols);
            }
        }

        // Column logic
        for(int c=0; c<cols; c++){
            // Get count of 0s' & 1s' in a column
            int zeroc = 0, onec = 0;
            for(int r=0; r<rows; r++){
                if(grid[r][c]==0) zeroc++;
                else onec++;
            }

            if(zeroc>onec){
                flip_col(c, grid, rows);
            }
        }
        
        // Get binary strings for extracting values
        for(int i=0;  i<rows; i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<cols; j++){
                sb.append(grid[i][j]);
            }
            String bS = sb.toString();
            res+=Integer.parseInt(bS, 2);
        }
        return res;
    }

    public static void flip_row(int r, int[][] grid, int col){
        for(int i=0; i<col; i++){
            if(grid[r][i]==1) grid[r][i]=0;
            else grid[r][i]=1;
        }
    }

    public static void flip_col(int c, int[][] grid, int rows){
        for(int i=0; i<rows; i++){
            if(grid[i][c]==0) grid[i][c]=1;
            else grid[i][c]=0;
        }
    }
}