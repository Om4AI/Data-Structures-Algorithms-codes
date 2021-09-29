class Solution {
    public void moveZeroes(int[] nums) {
        int zp = -1;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                zp++;
                int t = nums[zp];
                nums[zp] = nums[i];
                nums[i] = t;
            }
        }
    }
}
