// Code by @Om
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0, j= n-1, max = Integer.MIN_VALUE;
        while (i<j){
            int val = nums[i] + nums[j];
            max = Math.max(val, max);
            i++;
            j--;
        }
        return max;
    }
}
