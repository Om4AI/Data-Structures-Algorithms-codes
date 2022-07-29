class Solution {
    public static int n;
    public void rotate(int[][] mat) {
        n = mat.length;
        transpose(mat);
        reflect(mat);
    }


    public static void transpose(int[][] mat){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }

    public static void reflect(int[][] mat){
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int t = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = t;
            }
        }
    }
}
