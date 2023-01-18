import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int p = 1;
        
        int l = 0, r = n-1, u = 0, d = n-1;
        while(l<=r && u<=d && p<=(n*n)){
            // Movement: l->r
            for(int i=l; i<=r; i++){
                res[u][i] = p;
                p++;
            }
            u++;

            // Movement: u->d
            for(int i=u; i<=d; i++){
                res[i][r] = p;
                p++;
            }
            r--;

            // Movement: r->l
            // Condition: Ensures that there are 2 rows (=====) and that we are not coming in  the opposite direction
            if(d>=u){
                for(int i=r; i>=l; i--){
                    res[d][i] = p;
                    p++;
                }
                d--;
            }

            // Movement: d->u
            // Condition: Ensures that there are 2 columns (||) and that we are not coming in  the opposite direction upwards
            if(r>=l){
                for(int i=d; i>=u; i--){
                    res[i][l] = p;
                    p++;
                }
                l++;
            }
        }
        return res;
    }
}