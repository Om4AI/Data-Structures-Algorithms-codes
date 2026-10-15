import java.util.*;

// Logic -
// The maximum digit is 9 hence the sum of squares would be maximum when we maximize the number of 9s'
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuffer sb = new StringBuffer();
        // Base cases
        if (sum>(num*9)) return "";
        else if (sum==(num*9)){
            StringBuffer temp = new StringBuffer();
            for (int i=0; i<num; i++) temp.append('9');
        }

        int nines = sum/9;
        int rem = sum%9;
        for (int i=0; i<nines; i++){
            sb.append('9');
        }
        if (rem>0){
            sb.append(String.valueOf(rem));
        }
        int zeroes = num-sb.length();
        for (int i=0; i<zeroes; i++){
            sb.append('0');
        }
        return sb.toString();
    }
}