// Code by @Om 
import java.util.*;

class Solution {

    // Check if all the occurences in HashMap are unique
    static int check_map(HashMap<Character, Integer> map){
        int f = 1;
        for (Character key: map.keySet()){
            int occ = map.get(key);
            if (key!=('.') && (occ>1)){
                f = 0;
            }
        }
        return f;
    }

    // Check if all the rows follow sudoku rules
    static int check_rows(char[][] arr){
        int f = 1;
        // Rows 
        for (int i=0; i<9; i++){
            HashMap<Character, Integer> map = new HashMap();
            // Columns 
            for (int j=0; j<9; j++){
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
            }
            f = check_map(map);
            if (f==0){
                return f;
            }
        }
        return f;
    }

    // Check if all the columns follow sudoku rules
    static int check_columns(char[][] arr){
        int f = 1;
        // Rows 
        for (int j=0; j<9; j++){
            HashMap<Character, Integer> map = new HashMap();
            // Columns 
            for (int i=0; i<9; i++){
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
            }
            f = check_map(map);
            if (f==0){
                return f;
            }
        }
        return f;
    }

    // Check each sub-sudoku (Generalized Function)
    static int checkbox(int a,int c,int d,int f, char[][] arr){
        int fl = 1;
        HashMap<Character, Integer> map = new HashMap();
        for (int i=a; i<=c; i++){
            for (int j=d; j<=f; j++){
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
            }
            fl = check_map(map);
            if (fl==0) return fl;
        }
        return fl;
    }

    // Check sub-sudokus in the main sudoku
    static int check_subboxes(char[][] arr){
        int f = 1;
        for (int i=0; i<=6; i+=3){
            for (int j=0; j<=6; j+=3){
                f = checkbox(i, i+2, j, j+2, arr);
                if (f==0) return f;
            }
        }
        return f;
    }

    // Main function to call all functions
    public boolean isValidSudoku(char[][] board) {
        // Numbers are numbers; blanks are (.)s'
        int rf = check_rows(board);
        int cf = check_columns(board);
        int subf = check_subboxes(board);
        if (rf==1 && cf==1 && subf==1) return true;
        else return false;
    }
}
