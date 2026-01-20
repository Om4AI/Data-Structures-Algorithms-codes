import java.util.*;

class Solution {
    private int add_entry(char[] chars, int m, char curr_char, int curr_count){
        // Add the entry to array
        chars[m] = curr_char;
        // Add the count to the array
        if (curr_count<10 && curr_count>1){
            m++;
            chars[m] = Character.forDigit(curr_count, 10);
        }else if(curr_count>=10){
            String count = String.valueOf(curr_count);
            for (int j=0; j<count.length(); j++){
                m++;
                chars[m] = count.charAt(j);
            }
        }
        return m;
    }


    public int compress(char[] chars) {
        char curr_char = chars[0];
        int curr_count = 0;
        int m=0;
        for (int i=0; i<chars.length; i++){
            char nxt_char = chars[i];
            if (nxt_char == curr_char){
                curr_count++;
            }else{
                m = add_entry(chars, m, curr_char, curr_count);
                // Setup next process
                curr_char = nxt_char;
                m++;
                curr_count = 1;
            }
        }
        // Add the entry to array
        m = add_entry(chars, m, curr_char, curr_count);
        return m+1;
    }
}