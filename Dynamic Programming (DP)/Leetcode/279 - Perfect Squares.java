import java.util.*;
import java.lang.Math;

class Solution {
    public static int expected;
    public static int arr[];
    public static int t[][];
    public int numSquares(int n) {
        // Initialize variables
        expected = n;

        // Create an array of perfect squares till sqrt(n)
        int sqrt_n = (int)Math.sqrt(n);
        arr = new int[sqrt_n+1];
        for (int i=0; i<=sqrt_n; i++){
            arr[i] = i*i;
        }

        // Memoization initialization & call
        t = new int[expected+1][sqrt_n+1];
        for (int i=0; i<t.length; i++){
            Arrays.fill(t[i], -1);
        }
        return Least_numof_squares(0, arr.length-1);
    }

    public static int Least_numof_squares(int total, int index){
        // Edge cases
        if (total==expected) return t[total][index] = 0;
        if (index==0 || total>expected) return expected+1;

        // Memoization
        if (t[total][index] != -1) return t[total][index];

        // Accept the current square
        int accept = Math.min(1+Least_numof_squares(total+arr[index], index), 1+Least_numof_squares(total+arr[index], index-1));

        return t[total][index] = Math.min(accept, Least_numof_squares(total, index-1));
    }
}