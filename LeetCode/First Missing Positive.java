class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = 1;
        if (nums.length ==0){res = 1;}
        else{
        //         Sort 
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                int temp;
                if (nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
//         Logic for number return
        if (nums[0]>1){res = 1;}
        else{
            for (int i=0; i<nums.length; i++){
                if (nums[i] > 0 && nums[i] ==res){res+=1;}
            }
        }
        }

        return res;
    }
}
