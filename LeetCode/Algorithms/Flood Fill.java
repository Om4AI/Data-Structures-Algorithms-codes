class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color!=newColor) dfs_cc(image, sr, sc, color, newColor);
        return image;
    }
    
    public static void dfs_cc(int[][] image, int r, int c, int color, int newcolor){
//         Check if the cell contains the same color that's required
        if (image[r][c]==color){
            image[r][c] = newcolor;
//             DFS up the column & left to the row end
            if(r-1>=0) dfs_cc(image,r-1,c,color,newcolor);
            if (c-1>=0) dfs_cc(image,r,c-1,color,newcolor);
//             DFS down the column & right in the row
            if (r+1<image.length) dfs_cc(image, r+1,c,color, newcolor);
            if(c+1<image[0].length) dfs_cc(image,r,c+1,color, newcolor);  
        }
    }
}
