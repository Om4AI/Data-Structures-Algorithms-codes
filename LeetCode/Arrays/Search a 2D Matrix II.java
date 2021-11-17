class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
//         Find range 
        int index=0;
        for (int i=0; i<matrix.length; i++){
            int len = matrix[i].length;
            if(target>=matrix[i][0] && target<=matrix[i][len-1]){
                if(checkPresent(matrix,target,i)) return true;
            }
        }
        return false;
    }
    
    public boolean checkPresent(int[][] matrix, int target, int index){
        for(int i=0; i<matrix[index].length; i++){
            if(matrix[index][i]==target) return true;
        }
        return false;
    }
}
