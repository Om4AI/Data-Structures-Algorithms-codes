class Solution {
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        canSolveSudoku(0,0);
    }

    public boolean canSolveSudoku(int row, int col){

        // Base cases (Where recursive calls end)
        if(col==9){
            col=0;
            row++;
        }
        if(row==9) return true;

        // Cell already filled
        if(board[row][col]!='.') return canSolveSudoku(row, col+1);

        for(char i='1';i<='9'; i++){
            if(isValidPos(row,col,i)) board[row][col] = i;
            else continue;

            if(canSolveSudoku(row,col+1)==true) return true;
            board[row][col]='.';
        }
        return false;
    }

    public boolean isValidPos(int row, int col, char ch){
        // Check row
        for(int i=0; i<9; i++){
            if(board[row][i]==ch) return false;
        }
        
        // Check column 
        for (int i=0; i<9; i++){
            if(board[i][col]==ch) return false;
        }
        
        // Check sub sudoku
        int r=0, c=0;
        if (row>=0 && row<=2) r = 0;
        else if (row>=3 && row<=5) r = 3;
        else r=6;
        
        if (col>=0 && col<=2) c = 0;
        else if (col>=3 && col<=5) c = 3;
        else c=6;
        
        for (int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if (board[i][j]==ch) return false;
            }
        }
        return true;
    }
}