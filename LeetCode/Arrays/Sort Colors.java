class Solution {
    public void sortColors(int[] nums) {
//         Pass 1 - 0s' sort
        int p=0;
        for (int i=0; i<nums.length; i++){
            if(nums[i]==0){
                int t = nums[p];
                nums[p] = 0;
                nums[i] = t;
                p++;
            }
        }
//         Pass 2 - 1s' sort
        for (int i=0; i<nums.length; i++){
            if(nums[i]==1){
                int t = nums[p];
                nums[p] = 1;
                nums[i] = t;
                p++;
            }
        }
    }
}
