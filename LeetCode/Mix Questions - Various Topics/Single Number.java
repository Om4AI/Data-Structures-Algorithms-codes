class Solution {
    static int count(int arr[], int el){
        int count = 0 ;
        for (int i=0; i<arr.length; i++){
            if (arr[i]==el){
                count+=1;
            }
        }
        return count;
    }


    public int singleNumber(int[] nums) {
        int c,i, f=0;
        for (i = 0; i<nums.length-1; i++){
            c= count(nums, nums[i]);
            if (c==1){
                f=1;
                break;
            }
        }
        if (f==1){return nums[i];}
        else{return nums[nums.length-1];}
    }
}
