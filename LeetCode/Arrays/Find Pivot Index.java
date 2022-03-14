class Solution {
    public int pivotIndex(int[] nums) {
        int left[] = new int[nums.length], right[] = new int[nums.length];
        int sum = 0;
        
        // Fill the left sum array
        for(int i=1; i<nums.length; i++){
            sum+=nums[i-1];
            left[i] = sum;
        }
        sum = 0;
        // Fill the right sum array
        for(int i=nums.length-2; i>=0; i--){
            sum+=nums[i+1];
            right[i] = sum;
        }
        
        // Get result
        for(int i=0; i<nums.length; i++){
            if(left[i]==right[i]) return i;
        }
        return -1;
    }
}
