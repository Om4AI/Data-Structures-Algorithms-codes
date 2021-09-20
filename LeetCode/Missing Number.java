class Solution {
    public int missingNumber(int[] nums) {
        int p = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=p){
                break;
            }else p+=1;
        }
        return p;
    }
}
