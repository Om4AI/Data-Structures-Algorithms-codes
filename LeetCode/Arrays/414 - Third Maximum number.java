import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int max_count = 1;
        int n = nums.length;
        int curr = nums[n-1];
        for(int i=n-1; i>=0; i--){
            if (nums[i] < curr){
                if (max_count == 2){
                    return nums[i];
                }else{
                    curr = nums[i];
                    max_count++;
                }
            }
        }
        return nums[n-1];
    }
}