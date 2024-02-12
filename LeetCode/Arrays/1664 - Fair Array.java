import java.util.*;

class Solution {
    public int waysToMakeFair(int[] arr) {
        int n = arr.length, total = 0;
        int even[] = new int[n];
        int odd[] = new int[n];
        // Edge case
        if (n==1) return 1;

        // Populate even and odd arrays
        even[0] = arr[0];
        for(int i=1; i<n; i++){
            if (i%2==0){
                // Even
                odd[i] = odd[i-1];
                even[i] = even[i-1]+arr[i];
            }else{
                // Odd
                even[i] = even[i-1];
                odd[i] = odd[i-1]+arr[i];
            }
        }

        // Final sums
        int even_total = even[n-1], odd_total = odd[n-1];

        // Find the number of special elements
        int special = 0;
        for (int i=1; i<n-1; i++){
            int odd_rem = odd_total-odd[i];
            int even_rem = even_total-even[i];

            if((odd[i-1]+even_rem)==(even[i-1]+odd_rem)){
                special++;
            }
        }

        // Starting and ending indices
        if ((odd_total-odd[0])==(even_total-even[0])) special++;
        if (odd[n-2]==even[n-2]) special++;

        return special;
    }
}