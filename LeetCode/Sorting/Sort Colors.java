// Code by @Om

class Solution {
    public void sortColors(int[] nums) {
        int z = 0, o = 0, t = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0) z+=1;
            else if(nums[i]==1) o+=1;
            else t+=1;
        }
        int j=-1;
        while (z>0 || o>0 || t>0){
            j+=1;
            if (z==0 && o==0){
                nums[j] =2;
                t--;
            }
            else if (z==0){
                nums[j] = 1;
                o--;
            }
            else{
                nums[j] = 0;
                z--;
            }
        }
    }
}
