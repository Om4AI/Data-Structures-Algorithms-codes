// Code by @Om Mule

class Solution {
    public void nextPermutation(int[] nums) {
        int f = 0;
        for (int i=nums.length-1; i>=0; i--){
            
//             Right extreme case
            if (nums.length>1 && i==nums.length-1){
                if (nums[i]>nums[i-1]){
                    int t = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = t;
                    break;
                }
            }

//             General case middle element
            else if (nums.length>1 && nums[i]>=nums[i+1] && (i)!=0 && nums[i]>nums[i-1]){
                f = 1;
//                 Sort in ascending order including order (i to n) & break
                for (int j=i; j<nums.length-1; j++){
                    for (int k=j+1; k<nums.length; k++){
                        if (nums[j]>nums[k]){
                            int t;
                            t = nums[j];
                            nums[j] = nums[k];
                            nums[k] = t;
                        }
                    }
                }
//                 Interchange with the (i-1)th element
                int el = nums[i-1];
                for (int m=i; m<nums.length; m++){
                    if (nums[m] - el >= 1){
                        nums[i-1] = nums[m];
                        nums[m] = el;
                        break;
                    }
                }
                break;
            }
            else if (nums.length>1 && i==0 && nums[i]>=nums[i+1]){
                f = 1;
                //Sort in ascending(no interchange) & break
                for (int j=i; j<nums.length-1; j++){
                    for (int k=j+1; k<nums.length; k++){
                        if (nums[j]>nums[k]){
                            int t;
                            t = nums[j];
                            nums[j] = nums[k];
                            nums[k] = t;
                        }
                    }
                }
                break;
            }
        }
    }
}
