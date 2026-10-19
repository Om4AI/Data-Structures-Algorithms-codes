import java.util.*;

class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, c = 0;
        while (r<=m && c<=n){
            if (grid[r][c] == 'R'){
                if (c==n) return new int[]{r,c};
                else if (grid[r][c+1]=='1') return new int[]{r,c};
                else if (grid[r][c+1]!='1'){
                    grid[r][c] = '1';
                    c++;
                }
            }else if (grid[r][c] == 'L'){
                if (c==0) return new int[]{r,c};
                else if (grid[r][c-1]=='1') return new int[]{r,c};
                else if (grid[r][c-1]!='1'){
                    grid[r][c] = '1';
                    c--;
                }
            }else if (grid[r][c] == 'U'){
                if (r==0) return new int[]{r,c};
                else if (grid[r-1][c]=='1') return new int[]{r,c};
                else if (grid[r-1][c]!='1'){
                    grid[r][c] = '1';
                    r--;
                }
            }else if (grid[r][c] == 'D'){
                if (r==m) return new int[]{r,c};
                else if (grid[r+1][c]=='1') return new int[]{r,c};
                else if (grid[r+1][c]!='1'){
                    grid[r][c] = '1';
                    r++;
                }
            }
        }
        return new int[]{r,c};
    }
}