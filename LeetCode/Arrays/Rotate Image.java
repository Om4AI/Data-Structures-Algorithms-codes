class Solution {
    public void rotate(int[][] m) {
        List<List<Integer>> res = new ArrayList<>();

        // Rotate Image
        for (int i=0;i<m.length; i++){
            List<Integer> l = new ArrayList<>();
            for (int j=m.length-1; j>=0; j--){
                l.add(m[j][i]);
            }
            res.add(l);
        }

        // Create final result
        for (int i=0; i<res.size(); i++){
            for (int j=0; j<res.size(); j++){
                m[i][j] = res.get(i).get(j);
            }
        }
    }
}
