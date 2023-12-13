import java.util.*;

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n  = mat[0].length;
        HashMap<Integer, Integer> imap = new HashMap<>();
        HashMap<Integer, Integer> jmap = new HashMap<>();
        int res_count = 0;

        // Get the positions of 1s' in the matrix and add it to a set
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j]==1){
                    imap.put(i, imap.getOrDefault(i, 0)+1);
                    jmap.put(j, jmap.getOrDefault(j, 0)+1);
                }
            }
        }

        // Compare and count the special positions
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(mat[i][j]==1){
                    if (!(imap.get(i)>1) && !(jmap.get(j)>1)){
                        res_count++;
                    }
                }
            }
        }
        return res_count;
    }
}