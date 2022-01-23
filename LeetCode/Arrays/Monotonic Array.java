class Solution {
    public boolean isMonotonic(int[] nums) {
        int in = 1, dc = 1;
//         Incresing check
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]<nums[i]) in = 0;
        }
        
//         Decreasing check
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]>nums[i]) dc = 0;
        }
        return (in==1 || dc==1);
    }
}
