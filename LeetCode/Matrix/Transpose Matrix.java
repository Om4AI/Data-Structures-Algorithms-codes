class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, p =0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++) res.add(new ArrayList<>());
        
        for(int i=0; i<m; i++){
            for(int j=0; j<matrix[i].length; j++){
                int el = matrix[i][j];
                res.get(p%n).add(el);
                p++;
            }
        }
        
        int[][] transpose = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                transpose[i][j] = res.get(i).get(j);
            }
        }
        return transpose;
    }
}
