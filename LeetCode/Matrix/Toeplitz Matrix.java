class Solution {
    public boolean isToeplitzMatrix(int[][] mat){
        int m = mat.length, n = mat[0].length, i=m-1, j = 0, f=1;
        
        while(i!=0 || j!=n-1){
            if (!check_diag(i, j, m, n, mat)) f=0;
            
//             Change i & j
            if(i==0 && j==0 && j<=n-1) j++;
            else if(i>j) i--;
            else if(j>i && j<=n-1) j++;
        }
        return f==1;
    }
    
    public static boolean check_diag(int i, int j, int m, int n, int[][] mat){
        int num = mat[i][j];
        while(i<=m-1 && j<=n-1){
            if(mat[i][j]!=num) return false;
            i++;
            j++;
        }
        return true;
    }
}
