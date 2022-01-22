class Solution {
    public void setZeroes(int[][] matrix) {
//         Locate 0s' first
//         Rows
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        for (int i=0; i<matrix.length; i++){
//             Columns
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j]==0){
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        // System.out.println(list);
//         Make the rows & columsn 0s'
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (list1.contains(i) || list2.contains(j)){matrix[i][j]=0;}
            }
        }
    }
}
