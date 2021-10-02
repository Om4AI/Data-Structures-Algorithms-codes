class Solution {
    int[][] grid;
    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        // Initialize grid array & seen boolean array
        this.grid=grid;
        seen = new boolean[grid.length][grid[0].length];

        int max_area=0;
        for (int r=0; r<grid.length; r++){
            for (int c=0; c<grid[0].length; c++){
                max_area = Math.max(max_area, area(r,c));
            }
        }
        return max_area;
    }

    public int area(int r, int c){

        // r & c constraints or value==0 or cell is already seen
        if (r<0|| r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0 || seen[r][c]) return 0;

        // New cell within all the constraints 
        seen[r][c] =  true;
        // Add 1 to the shape area along with adjacent cells recursive call
        return (1+area(r-1,c)+area(r+1,c)+area(r,c-1)+area(r,c+1));
    }
}