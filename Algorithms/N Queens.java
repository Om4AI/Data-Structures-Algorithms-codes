// Code by @Om

import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        HashSet<List<String>> res = new HashSet<>();
        for(int i=0; i<n; i++){
            NQueens_backtrack(res,new int[n][n],n,0,i);
        }
        return new ArrayList<>(res);
    }

    boolean NQueens_backtrack(HashSet<List<String>> res,int[][] board,int n,int row,int gc){
        if(row==n){
            // Store result
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0; j<n; j++){
                    if(board[i][j]==1){
                        sb.append("Q");
                        board[i][j] = 0;
                    }
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return true;
        }

        for(int col=gc; col<n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                if(NQueens_backtrack(res,board,n,row+1,0)){
                    return true;
                }

                // Backtrack step (IF the above condition fails)
                board[row][col] = 0;               
            }
        }
        return false;
    }

    public boolean isSafe(int[][] board,int row, int col, int n){


        // Check row to left of element
        for (int i=0; i<col; i++){
            if(board[row][i]==1) return false;
        }

        // Check column above element
        for(int i=0; i<row; i++){
            if(board[i][col]==1) return false;
        }

        // Check upper diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]==1) return false;
        }

        // Check lower diagonal
        for(int i=row, j=col;i>=0 && j<n; i--,j++){
            if(board[i][j]==1) return false;
        }
        return true;
    }
}

public class NQueens{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.solveNQueens(n));
    }
}
