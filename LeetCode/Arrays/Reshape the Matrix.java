class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                l.add(mat[i][j]);
            }
        }
        int p = -1;
        if (r*c != l.size()) return mat;
        int[][] res = new int[r][c];
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                p++;
                res[i][j] = l.get(p);
            }
        }
        return res;
    }
}
