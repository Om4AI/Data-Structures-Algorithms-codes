import java.util.*;
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowB = 0, rowE = n-1, colB = 0, colE= n-1, p=1;
        while (rowB<=rowE && colB<=colE && p<=Math.pow(n,2)){

            // First loop
            for (int i=colB; i<=colE; i++){
                res[rowB][i] = p;
                p++;
            }
            rowB++;
            // Second loop
            for (int i=rowB; i<=rowE; i++){
                res[i][colE] = p;
                p++;
            }
            colE--;
            // Third loop
            if (rowB<=rowE){
                for (int i=colE; i>=colB; i--){
                    res[rowE][i] = p;
                    p++;
                }
                rowE--;
            }
            // Fourth loop
            if (colB<=colE){
                for (int i=rowE; i>=rowB; i--){
                    res[i][colB] = p;
                    p++;
                }
                colB++;
            }

        }
        return res;
    }
}
