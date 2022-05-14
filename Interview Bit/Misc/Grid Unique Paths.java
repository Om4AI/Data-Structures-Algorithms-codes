public class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        int t[][] = new int[m+1][n+1];
        for(int k=0; k<m+1; k++){
            Arrays.fill(t[k],-1);
        }
        t[m-1][n-1] = 1;
        return get_paths(m, n, i, j,t);
    }
    
    public static int get_paths(int m, int n, int i, int j, int[][] t){
        // Base condition
        if(i==m-1 && j==n-1) return 1;
        
        // Check in the memoization matrix
        if(t[i][j]!=-1) return t[i][j];
        
        //Recursive call
        int right =0, down =0;
        if(i+1<=m-1){
            down = get_paths(m,n,i+1,j,t);
        }
        if(j+1<=n-1) right = get_paths(m,n,i,j+1,t);
        
        return t[i][j] = right+down;
    }
}