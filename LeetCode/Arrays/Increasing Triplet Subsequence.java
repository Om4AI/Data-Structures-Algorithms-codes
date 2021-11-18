class Solution {
    public boolean increasingTriplet(int[] nums){
        int len = nums.length;
        int[] minleft = new int[len];
        int[] maxright = new int[len];
        
//         Get minimums to left
        int min = nums[0];
        for (int i=0; i<len; i++){
            int el = nums[i];
            minleft[i] = Math.min(min,el);
            min = minleft[i];
        }
        
//         Get maximums from right
        int max = nums[len-1];
        for (int i=len-1; i>=0; i--){
            int el = nums[i];
            maxright[i] = Math.max(max,el);
            max = maxright[i];
        }
        
//         Final check
        for (int i=0; i<len; i++){
            if(nums[i]>minleft[i] && nums[i]<maxright[i]) return true;
        }
        return false;
    }
}
