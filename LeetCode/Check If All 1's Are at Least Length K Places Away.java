class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int t, f=1;
        for (int i =0; i<n-1; i++){
            if (nums[i]==1){
                for (int j=i+1; j<n; j++){
                    if (nums[j]==1){
                        t = j-i-1;
                        if (t<k){
                            f = 0;
                        }
                        else{
                            i =j;
                        }
                    }
                }
            }   
        }
        if (f == 1){return true;}
        else{return false;}
    }
}
