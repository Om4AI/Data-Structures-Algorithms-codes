// Approach 1: Brute Force Approach
class Solution {
    public int minDeletionSize(String[] strs){
        int m = strs.length, n = strs[0].length();
        Character[][] mat = new Character[m][n];
        int res = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = strs[i].charAt(j);
            }
        }

        // Check each column 
        for(int j=0; j<n; j++){
            for(int i=0; i<m-1; i++){
                if((mat[i][j] - mat[i+1][j])>0){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
