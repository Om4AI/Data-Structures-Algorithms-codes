import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }
}
