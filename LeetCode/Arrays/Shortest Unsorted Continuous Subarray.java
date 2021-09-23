import java.util.*;
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int  n = nums.length;
        int[] c = new int[n];
        for (int i=0; i<n; i++){
            c[i] = nums[i];
        }
        Arrays.sort(c);
        int s=0, e=0;
        for (int i=0; i<n; i++){
            if (nums[i]!=c[i]){
                s = i;
                break;
            }
        }
        for (int i=n-1; i>=0; i--){
            if (nums[i]!=c[i]){
                e = i;
                break;
            }
        }
        if (s==e) return 0;
        return e-s+1;
    }
}
