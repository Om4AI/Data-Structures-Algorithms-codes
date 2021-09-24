class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        // O(2n) Approach
        // Find the row where element can be
        int t= 0;
        for (int i=0; i<mat.length; i++){
            int el = mat[i][mat[i].length-1];
            if (el>=target){
                t = i;
                break;
            }
        }

        // Check element presence
        for (int i=0; i<mat[t].length; i++){
            if (mat[t][i]==target) return true;
        }
        return false;
    }
}
