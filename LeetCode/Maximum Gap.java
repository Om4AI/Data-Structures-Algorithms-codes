// Sorting

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if (nums.length<2) return 0;
        else{
            int max_diff = 0;
            for (int i=0; i<nums.length-1; i++){
                if ((nums[i+1]-nums[i]) > max_diff) max_diff = (nums[i+1]-nums[i]);
            }
            return max_diff;
        }
    }
}
