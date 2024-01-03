import java.util.*;

class Solution {
    public static int count_ones(String s){
        // Count the number of set bits(1s') in the binary string
        int total = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='1') total++;
        }
        return total;
    }

    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int count = 0;
        // Edge case - Single row
        if (n==1) return 0;

        // Array for storing laser counts in each row
        int arr[] = new int[n];
        
        // Create array with number of lasers in each row
        for (int i=0; i<n; i++){
            arr[i] = count_ones(bank[i]);
        }

        // Cases to traverse the array of count of set bits
        int px = 0, py = 1;
        while (px<py && py<n){
            int x = arr[px];
            int y = arr[py];
            if (x==0 && y==0){
                px+=2;
                py+=2;
            }else if (y==0){
                py++;
            }else if (x==0 && y>0){
                px = py;
                py++;
            }else{
                count += (x*y);
                px = py;
                py++;
            }
        }
        return count;
    }
}