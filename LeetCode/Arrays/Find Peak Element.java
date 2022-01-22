// Code by @Om Mule

class Solution {
    public int findPeakElement(int[] nums) {
        int index = 0;
        for (int i=0; i<nums.length; i++){
            if ((i==0 || i==nums.length-1) && nums.length>=2){
                if (i==0){
                    if (nums[0] >= nums[1]){
                        index = 0;
                        break;
                    }
                }
                else{
                    if (nums[i] >= nums[i-1]){
                        index = i;
                        break;
                    }
                }
            }
            else if (nums.length < 2){
                index = 0;
                break;
            }
            else{
                if (nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                    index = i;
                    break;
                }
            }
            
        }
        return index;
    }
}
