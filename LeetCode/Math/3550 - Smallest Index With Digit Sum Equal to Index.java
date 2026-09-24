import java.util.*;

class Solution {
    public int smallestIndex(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++){
            int sum = 0, temp = arr[i];
            while (temp>0){
                sum += temp%10;
                temp = temp/10;
            }
            if (sum==i) return i;
        }
        return -1;
    }
}