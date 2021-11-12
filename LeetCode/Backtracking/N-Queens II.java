import java.util.*;
class Solution {
    public int totalNQueens(int n){
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        List<List<String>> res = new ArrayList<>();
        // 0 - Is the row here
        backtrack(n,board,0,res);
        return res.size();
    }

    // Main Backtracking Function 
    public void backtrack(int n, char[][] board, int row,List<List<String>> res){
        if(row==n){
            res.add(construct_boardlist(board));
            return;
        }

        for(int col=0; col<n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                backtrack(n,board,row+1,res);
                board[row][col] = '.';
            }
        }
    }
    // BT Function Ends

    public List<String> construct_boardlist(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<board.length; j++){
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public boolean isSafe(char[][] board,int row, int col, int n){


        // Check row to left of element
        for (int i=0; i<col; i++){
            if(board[row][i]=='Q') return false;
        }

        // Check column above element
        for(int i=0; i<row; i++){
            if(board[i][col]=='Q') return false;
        }

        // Check left upper diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        // Check right upper diagonal
        for(int i=row, j=col;i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
