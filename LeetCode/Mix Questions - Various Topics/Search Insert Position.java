class Solution {
    public int searchInsert(int[] nums, int target) {
        int i,j,res=0,f = 0;
        for (i=0; i<nums.length; i++){
            if (nums[i]==target){
                f=1;
                res = i;
                break;
            }
        }
        if (f==0){
            int f1 = 0;
            for (j =0; j<nums.length; j++){
                if(nums[j]>target){
                    f1 = 1;
                    res = j;
                    break;
                }
            }
            if (f1 == 0){
                res = nums.length;
            }
        }
        return res;
    }
}
