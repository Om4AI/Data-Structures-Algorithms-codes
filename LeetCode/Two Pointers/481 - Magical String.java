import java.util.*;

// Conditions: 
    // 1. Occurences should be of the same number 
    // 2. The numbers should alternate (1, 2, 1, 2, .....)

// Logic ----->
    // while (total_nums < n)
    // Put in the next number
    // occ_ptr++ & add occ_ptr(val)-1 of the next_num
    // Total nums += occ_val
    // Alternate next_num

class Solution {
    public int magicalString(int n) {
        int occ_ptr = -1;
        char next_num = '1';
        int total_nums = 0;
        int ones = 0;
        StringBuffer sb = new StringBuffer();
        
        while (total_nums < n){
            sb.append(next_num);
            occ_ptr++;
            int occurence = Character.getNumericValue(sb.charAt(occ_ptr));
            for (int i = 0; i < occurence-1; i++) {
                sb.append(next_num);
            }
            total_nums += occurence;
            next_num = next_num=='1'? '2':'1';
        }

        for (int i=0; i<sb.length(); i++){
            if (sb.charAt(i)=='1'){
                ones++;
            }
        }
        return ones;
    }
}   
