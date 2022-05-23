class Solution {
    public int numIslands(char[][] grid) {
        int count =0;

        // Loop through the whole grid
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    // Atleast that Island exists
                    count++;
                    islandDFS(i,j,grid);
                }
            }
        }
        return count;
    }

    public static void islandDFS(int i, int j, char[][] grid){
        // Check further grid only if current cell is 1
        if(grid[i][j]=='1'){
            grid[i][j] = '0';
            if(i>=1) islandDFS(i-1,j,grid);
            if(j>=1) islandDFS(i,j-1,grid);
            if(i+1<grid.length) islandDFS(i+1,j,grid);
            if(j+1<grid[0].length) islandDFS(i,j+1,grid);
        }
        // If current cell is 0
        else return;
    }

}