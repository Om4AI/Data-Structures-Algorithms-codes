class Solution {
    public int maxProduct(int[] nums) {
        int max = 0, n = nums.length;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                int temp = (nums[i]-1) * (nums[j]-1);
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
