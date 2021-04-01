class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        int i, f=0;
        for (i=0; i<nums.length; i++){
            if (nums[i] == target){
                res[0] = i;
                f=1;
                break;
            }
        }
        if (f==1){
            for (int j=i; j<nums.length; j++){
                if (nums[j] == target){
                    res[1] = j;
                }
            }
        }
        else{
            res[0] =-1;
            res[1] = -1;
        }
        return res;

    }
}