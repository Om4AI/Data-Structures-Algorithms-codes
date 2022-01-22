class Solution {
    public int[] runningSum(int[] nums) {
        int rs[] = new int[nums.length];
        for (int i=0; i<rs.length; i++){
            int sum =0;
            for (int j=0; j<=i; j++){
                sum += nums[j];
            }
            rs[i] = sum;
        }
        return rs;
    }
}
