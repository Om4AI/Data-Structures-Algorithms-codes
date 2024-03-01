import java.util.*;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        // Calculate the number of 1s'
        int n = s.length();
        int ones = 0;
        for (int i=0; i<n; i++){
            if (s.charAt(i)=='1') ones++;
        }
        
        // Construct the resultant string
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        for (int i=0; i<(n-ones); i++){
            sb.append("0");
        }
        for (int i=0; i<(ones-1); i++){
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}