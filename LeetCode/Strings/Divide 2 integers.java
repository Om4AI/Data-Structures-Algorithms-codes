// This gives TLE but is correct to find the answer

import java.util.*;
class Solution {
    public int divide(int dividend1, int divisor1) {

        long dividend = Long.valueOf(dividend1), divisor =Long.valueOf(divisor1);
        // Convert dividend and divisor to +ve numbers
        int ddn = 0, drn =0;
        String dd = String.valueOf(dividend);
        String dr = String.valueOf(divisor);

        if(dd.charAt(0)=='-') ddn =1;
        if(dr.charAt(0)=='-') drn =1;

        // Remove the negative signs
        if(ddn==1){
            StringBuffer sb = new StringBuffer(dd);
            sb.deleteCharAt(0);
            dividend = Long.parseLong(sb.toString());
        }
        if(drn==1){
            StringBuffer sb = new StringBuffer(dr);
            sb.deleteCharAt(0);
            divisor = Long.parseLong(sb.toString());
        }

        int one = 0;
        if(divisor==1) one =1;

        // Actual division
        long q =0;
        while(dividend>=divisor && divisor!=1){
            dividend-=divisor;
            q++;
        }
        
        if(one==1) q = dividend;

        // Take care of the -ve sign
        if((ddn==1 && drn==1)||(ddn==0 && drn==0)){
            // Bring q in range
            if(q>2147483647) q = 2147483647;
            return (int)q;
        }
        else return -1*(int)q;
    }
}
