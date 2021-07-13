class Solution {
    public boolean checkPossibility(int[] nums) {
//         Changes count
        int c = 0;
        for (int i=1; i<nums.length && c<=1; i++){
            if (nums[i-1] > nums[i]){
                c += 1;
                if ((i-2)<0 || nums[i-2]<= nums[i]) {
//                     Problem in the (i-1)th element
                    nums[i-1] = nums[i];
                }
                else{
//                     Problem in ith element
                    nums[i] = nums[i-1];
                }
            }
        }
        return c<=1;
    }
}
