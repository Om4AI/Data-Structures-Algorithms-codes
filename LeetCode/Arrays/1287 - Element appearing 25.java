import java.util.*;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int qtr = n/4;
        int curr = arr[0], curr_occ = 1;

        for (int i=1; i<n; i++){
            if (arr[i]==curr){
                curr_occ++;
            }else{
                if (curr_occ>qtr){
                    return arr[i-1];
                }
                curr = arr[i];
                curr_occ = 1;
            }
        }

        if (curr_occ>qtr){
            return arr[n-1];
        }
        return arr[0];
    }
}