class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(); 
        
        if (matrix.length==0) return res;

        int rowBegin = 0, rowEnd = matrix.length-1;
        int colBegin = 0, colEnd = matrix[0].length-1;

        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int i=colBegin; i<=colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin+=1;

            for (int i=rowBegin; i<=rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd-=1;

            if (rowBegin<=rowEnd){
                for (int i=colEnd; i>=colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd-=1;

            if (colBegin<=colEnd){
                for (int i=rowEnd; i>=rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin+=1;
        }
        return res;
    }
}
