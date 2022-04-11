class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int m = grid.length, n = grid[0].length;
        while(k-->0) grid = shift2D(grid);
        
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0; i<m; i++){
            List<Integer> temp = new ArrayList<>();
            for(int h = 0; h<n; h++){
                temp.add(grid[i][h]);
            }
            l.add(temp);
        }
        return l;
    }

    public static int[][] shift2D(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int res[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n-1; j++){
                res[i][j+1] = grid[i][j];
            }
        }
        
        int j = n-1;
        for(int i=0; i<m; i++){
            if(i==m-1) res[0][0] = grid[i][j];
            else res[i+1][0] = grid[i][j];
        }
        return res;
    }
}