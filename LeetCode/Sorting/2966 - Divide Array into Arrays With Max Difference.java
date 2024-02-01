/*
 * Greedy method is used when we can use the next best move
 * This mostly solves the problem. This problem is solved by
 * using sorting and greedy approach together.
 */
import java.util.*;
 class Solution {
    public int[][] divideArray(int[] arr, int k) {
        int n = arr.length;
        int res[][] = new int[n/3][3];
        Arrays.sort(arr);

        // Check elements on the intervals of 3 & create resultant array
        for (int i=0; i<=(n-3); i+=3){
            if ((arr[i+2]-arr[i])>k){
                return new int[0][0];
            }else{      
               // Create resultant array
                int[] temp = new int[3];
                temp[0] = arr[i];
                temp[1] = arr[i+1];
                temp[2] = arr[i+2];
                res[i/3] = temp;
            }
        }
        return res;
    }
}

