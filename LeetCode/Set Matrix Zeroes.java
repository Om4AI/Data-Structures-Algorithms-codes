class Solution {
    public void setZeroes(int[][] matrix) {
//         Locate 0s' first
//         Rows
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<matrix.length; i++){
//             Columns
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j]==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        // System.out.println(list);
//         Make the rows & columsn 0s'
        for (int j=0; j<list.size(); j++){
            int r = list.get(j).get(0);
            int c = list.get(j).get(1);
            System.out.println(r+" "+c);
            for (int i=0; i<matrix[r].length; i++){
                matrix[r][i] = 0;
            }
            for (int i=0; i<matrix.length; i++){
                matrix[i][c] = 0;
            }
        }
    }
}
