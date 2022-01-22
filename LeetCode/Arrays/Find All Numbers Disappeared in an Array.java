class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            int index = Math.abs(nums[i]) -1;
            
            if(nums[index] > 0){
                nums[index] = - nums[index];
            }
            
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                l1.add(i+1);
            }
        }
        
        return l1;
    }
}
