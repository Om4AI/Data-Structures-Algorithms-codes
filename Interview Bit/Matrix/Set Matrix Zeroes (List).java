public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a){
        int m = a.size(), n = a.get(0).size();
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();

        // Get indices of rows & columns
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(a.get(i).get(j)==0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Update the cells
        for(int i=0; i<m; i++){
            // Get a row list
            ArrayList<Integer> t = a.get(i);
            // Update the row
            for(int j = 0; j<n; j++){
                if(rows.contains(i) || columns.contains(j)){
                    t.set(j,0);
                }
            }
            a.set(i,t);
        }
	}
}
