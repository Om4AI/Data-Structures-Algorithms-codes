class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int ele[] = new int[m*n];
        int e=0;
        // Elements array
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                ele[e] = mat[i][j];
                e+=1;
            }
        }
        // Elements count
        if (ele.length != (r*c)){return mat;}
        else{
            int res[][] = new int[r][c];
            int z = 0;
            for (int i=0; i<r;i++){
                for (int j=0; j<c; j++){
                    res[i][j] = ele[z];
                    z+=1;
                }
            }
            return res;
        }
    }
}
