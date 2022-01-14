import java.util.*;
class Solution {
    public int divide(int dividend1, int divisor1) {

        long dividend = Long.valueOf(dividend1), divisor =Long.valueOf(divisor1);
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // Remove sign of dividend & divisor
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long q = 0, temp = 0;
        
        // Start from 31 according to (int) range
        // Instead of multiplying the number by 1 everytime before adding - Use powers of 2
        for(int i=31; i>=0; i--){
            
            // n<<i --> n*(2^i)
            if(temp+(divisor<<i)<=dividend){
                temp+=divisor<<i;
                q = q|1L<<i;
            }
        }

        if(sign==-1) q = -q;
        if(q>2147483647) q = 2147483647;
        return (int)q;
    }
}
