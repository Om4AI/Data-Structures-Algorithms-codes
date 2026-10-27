import java.util.*;

class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        // First row
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<n; i++){
            sb.append('.');
        }
        grid[0] = sb.toString();

        // Next rows
        for (int i=1; i<m; i++){
            sb.setLength(0);
            for (int j=0; j<n-1; j++){
                sb.append('#');
            }
            sb.append('.');
            grid[i] = sb.toString();
        }
        return grid;
    }
}