class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,j,t, f=0;
        int res[] = new int[2];
        int n = nums.length;
        for (i=0 ; i<n-1 ; i++){
            t = target - nums[i];
            for(j=i+1 ; j<n ; j++){
                if (nums[j] == t){
                    f = 1;
                    break;
                }
                else{continue;}
            }
            if (f == 1){
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }
}
