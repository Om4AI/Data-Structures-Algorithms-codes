// Brute Force O(n^2)
class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        
        for(int i=0; i<res.length; i++){
            int sum = 0;
            for (int j=0; j<res.length; j++){
                sum+= (Math.abs(j-i) * Character.getNumericValue(boxes.charAt(j)));
            }
            res[i] = sum;
        }
        return res;
    }
}

// Optimal Approach O(n) - 4ms
import java.util.*;

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int res[] = new int[n];
        int left_sum[] = new int[n];
        int right_sum[] = new int[n];
        int left_ones[] = new int[n];
        int right_ones[] = new int[n];
        int lsum=0, rsum=0, lones=0, rones=0;

        // Starting from left side
        for (int i=0; i<n; i++){
            int num = Character.getNumericValue(boxes.charAt(i));
            lsum+=(n-1-i)*num;
            left_sum[i] = lsum;
            if(num==1) lones++;
            left_ones[i] = lones;
        }

        // Starting from right side
        for (int i=n-1; i>=0; i--){
            int num = Character.getNumericValue(boxes.charAt(i));
            rsum+=(i-0)*num;
            right_sum[i] = rsum;
            if(num==1) rones++;
            right_ones[i] = rones;
        }

        // Final Calculation
        for (int i=0; i<n; i++){
            res[i] = (left_sum[i]-(left_ones[i]*(n-1-i))) + (right_sum[i]-(right_ones[i]*(i-0)));
        }
        return res;
    }
}
