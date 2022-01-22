class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        int pos = 0;
        while(pos < nums.length && nums[pos] != val)
            pos++;
        
        for(int i=pos+1; i<nums.length; i++){
            if(nums[i] != val){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }
        
        int count = 0;
        while(count < nums.length && nums[count] != val)
            count++;
        return count;
    }
}
