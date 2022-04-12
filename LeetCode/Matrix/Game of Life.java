class Solution {
    public void gameOfLife(int[][] board){
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int c = get_livecells(board,i,j);
                int curr = board[i][j];
                if(curr==1 && c<2) res[i][j] = 0;
                else if (curr==1 && c>3) res[i][j] =0;
                else if (curr==1) res[i][j] = 1;
                else if(curr==0 && c==3) res[i][j] = 1;
                else res[i][j] =0;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = res[i][j];
            }
        }
    }

    public static int get_livecells(int[][] board, int i, int j){ 
        int c=0, m = board.length, n = board[0].length;
        if(m==1 || n==1){
            if(m==1 && n==1) return 0;
            else if(m==1 && board[i][j]==1 && j!=0 && j!=n-1){
                if(board[i][j-1]==1 && board[i][j+1]==1) return 2;
            }else return 0;
        }
        if(m==1 && n==2 || m==2 && n==1) return 0;
        
        // Conditions
        if(j==0){
            if(i==0){
                c = c + board[i][j+1] + board[i+1][j+1] + board[i+1][j];
                return c;
            }else if(i<m-1){
                c = c + board[i][j+1] + board[i+1][j+1] + board[i+1][j] + board[i-1][j] + board[i-1][j+1];
                return c;
            }else{
                c = c + board[i][j+1] + board[i-1][j] + board[i-1][j+1];
                return c;
            }
        }else if (j==n-1){
            if(i==0){
                c = c + board[i][j-1] + board[i+1][j-1] + board[i+1][j];
                return c;
            }else if(i==m-1){
                c = c + board[i][j-1] + board[i-1][j] + board[i-1][j-1];
                return c;
            }else{
                c = c + board[i][j-1] + board[i+1][j-1] + board[i-1][j-1] + board[i-1][j] + board[i+1][j];
                return c;
            }
        }else if (i==0){
            c = c + board[i][j-1] + board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+1][j-1];
            return c;
        }else if (i==m-1){
            c = c + board[i][j-1] + board[i][j+1] + board[i-1][j] + board[i-1][j+1] + board[i-1][j-1];
            return c;
        }
        else {
            c = c + board[i][j-1] + board[i][j+1] + board[i-1][j] + board[i-1][j+1] + board[i-1][j-1] + board[i+1][j] + board[i+1][j+1] + board[i+1][j-1];
        }
        return c;
    }
}