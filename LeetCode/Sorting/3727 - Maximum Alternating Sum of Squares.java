import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums){
        // Convert to abs values & sort
        int n = nums.length;
        for (int i=0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        long res = 0;
        int s = 0, e = n-1;
        while (s<e){
            res += nums[e]*nums[e];
            res -= nums[s]*nums[s];
            s++;
            e--;
        }

        // Odd length
        if (n%2!=0) res+=nums[e]*nums[e];
        return res;
    }
}