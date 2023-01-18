import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        
        int l = 0, r = n-1, u = 0, d = m-1;
        while((r>=0 && l<n && l<=r) && (d>=0 && u<m && u<=d) && res.size()!=(m*n)){
            // Movement: l->r
            for(int i=l; i<=r; i++) res.add(mat[u][i]);
            u++;

            // Movement: u->d
            for(int i=u; i<=d; i++) res.add(mat[i][r]);
            r--;

            // Movement: r->l
            // Condition: Ensures that there are 2 rows (=====) and that we are not coming in  the opposite direction
            if(d>=u){
                for(int i=r; i>=l; i--) res.add(mat[d][i]);
                d--;
            }

            // Movement: d->u
            // Condition: Ensures that there are 2 columns (||) and that we are not coming in  the opposite direction upwards
            if(r>=l){
                for(int i=d; i>=u; i--) res.add(mat[i][l]);
                l++;
            }
        }
        return res;
    }
}
