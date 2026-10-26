class Cell{
    int r;
    int c;
    Cell (int i, int j){
        r = i;
        c = j;
    }
}

class Solution {
    public Queue<Cell> checkAllDirections(int i, int j, int[][] grid, Queue<Cell> q){
        int m = grid.length, n = grid[0].length;
        if (i>0 && grid[i-1][j]>0) q.add(new Cell(i-1, j)); // Up
        if (i<m-1 && grid[i+1][j]>0) q.add(new Cell(i+1, j)); // Down
        if (j>0 && grid[i][j-1]>0) q.add(new Cell(i, j-1)); // Left
        if (j<n-1 && grid[i][j+1]>0) q.add(new Cell(i, j+1)); // Right

        return q;
    }

    public int countIslands(int[][] grid, int divisor){
        int m = grid.length, n = grid[0].length, res = 0;
        Queue<Cell> q = new LinkedList<>();

        // Traverse
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] > 0){
                    long island = 0;
                    q.add(new Cell(i, j));
                    while (!q.isEmpty()){
                        int qs = q.size();
                        for (int k = 0; k<qs; k++){
                            Cell curr = q.poll();
                            // A previous queued copy already processed this cell.
                            if (grid[curr.r][curr.c] == 0) continue;

                            q = checkAllDirections(curr.r, curr.c , grid, q);
                            island += grid[curr.r][curr.c];
                            grid[curr.r][curr.c] = 0;
                        }
                    }
                    if (island % divisor == 0) res++;
                }
            }
        }
        return res;
    }
}