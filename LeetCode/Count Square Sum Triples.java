import java.util.*;

class Solution {
    public int countTriples(int n) {
        // Squares array
        int count =0;
        int squares[] = new int[n];
        for (int i=0; i<n; i++){
            squares[i] = (i+1)*(i+1);
        }

        for (int i=0; i<n; i++){
            int el = squares[i];
            for (int j=0; j<n; j++){
                if (squares[j] != squares[i]){
                    // Find sum
                    int sum = squares[i] + squares[j];
                    for (int k=0; k<n; k++){
                        if (sum == squares[k]){
                            count += 1;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
